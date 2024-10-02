package com.example.presentation.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.OffersAndVacancies
import com.example.domain.usecase.ChangeVacancyFavoriteStatusUseCase
import com.example.domain.usecase.GetOffersAndVacanciesUseCase
import com.example.domain.usecase.LoadOffersAndVacanciesUseCase
import com.example.presentation.mappers.OffersAndVacanciesDomainToUiMapper
import com.example.presentation.models.OffersAndVacanciesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val offersAndVacanciesDomainToUiMapper: OffersAndVacanciesDomainToUiMapper,
    private val getOffersAndVacanciesUseCase: GetOffersAndVacanciesUseCase,
    private val loadOffersAndVacanciesUseCase: LoadOffersAndVacanciesUseCase,
    private val changeVacancyFavoriteStatusUseCase: ChangeVacancyFavoriteStatusUseCase
) : ViewModel() {
    private val searchValue: MutableStateFlow<String> = MutableStateFlow("")

    private val currentOffersAndVacancies: MutableStateFlow<OffersAndVacanciesUi> =
        MutableStateFlow(
            OffersAndVacanciesUi()
        )

    private val _state: MutableStateFlow<MainScreenState> =
        MutableStateFlow(MainScreenState.Initial)

    private val state: StateFlow<MainScreenState> = _state

    init {
        viewModelScope.launch {
            loadOffersAndVacanciesUseCase()
            observeOffersAndVacancies()
        }
    }

    fun changeSearchValue(newValue: String) {
        viewModelScope.launch {
            searchValue.update { newValue }

            _state.update { currentState ->
                when (currentState) {
                    MainScreenState.Initial -> currentState
                    is MainScreenState.Main -> currentState.copy(searchValue = newValue)
                    is MainScreenState.More -> currentState.copy(searchValue = newValue)
                }
            }
        }
    }

    fun toMoreVacanciesState() {
        viewModelScope.launch {
            _state.update {
                MainScreenState.More(
                    vacancies = currentOffersAndVacancies.value.vacancies,
                    searchValue = searchValue.value
                )
            }
        }
    }

    fun toMainState() {
        viewModelScope.launch {
            _state.update {
                MainScreenState.Main(
                    offersAndVacancies = currentOffersAndVacancies.value,
                    searchValue = searchValue.value
                )
            }
        }
    }

    fun changeVacancyFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeVacancyFavoriteStatusUseCase(vacancyId)
            loadOffersAndVacanciesUseCase()
        }
    }

    fun getMainScreenState(): StateFlow<MainScreenState> = state

    private fun observeOffersAndVacancies() {
        getOffersAndVacanciesUseCase()
            .onEach { offersAndVacancies ->
                handleOffersAndVacancies(offersAndVacancies)
            }.launchIn(viewModelScope)
    }

    private fun handleOffersAndVacancies(offersAndVacancies: OffersAndVacancies) {
        val offersAndVacanciesUi =
            offersAndVacanciesDomainToUiMapper.map(offersAndVacancies)
        currentOffersAndVacancies.update {
            offersAndVacanciesUi
        }
        _state.update { currentState ->
            when (currentState) {
                MainScreenState.Initial -> MainScreenState.Main(
                    offersAndVacancies = currentOffersAndVacancies.value,
                    searchValue = searchValue.value
                )

                is MainScreenState.Main -> MainScreenState.Main(
                    currentOffersAndVacancies.value,
                    searchValue.value
                )

                is MainScreenState.More -> MainScreenState.More(
                    currentOffersAndVacancies.value.vacancies,
                    searchValue.value
                )
            }
        }
    }
}

