package com.example.presentation.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ChangeVacancyFavoriteStatusUseCase
import com.example.domain.usecase.GetFavoriteVacanciesUseCase
import com.example.domain.usecase.LoadOffersAndVacanciesUseCase
import com.example.presentation.mappers.VacancyDomainToUiMapper
import com.example.presentation.models.VacancyUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class FavoriteViewModel(
    private val vacancyDomainToUiMapper: VacancyDomainToUiMapper,
    private val getFavoriteVacanciesUseCase: GetFavoriteVacanciesUseCase,
    private val loadOffersAndVacanciesUseCase: LoadOffersAndVacanciesUseCase,
    private val changeVacancyFavoriteStatusUseCase: ChangeVacancyFavoriteStatusUseCase
) : ViewModel() {
    private val currentVacancies: MutableStateFlow<List<VacancyUi>> = MutableStateFlow(
        emptyList()
    )

    private val _state: MutableStateFlow<FavoriteScreenState> =
        MutableStateFlow(FavoriteScreenState.Initial)

    private val state: StateFlow<FavoriteScreenState> = _state

    init {
        viewModelScope.launch {
            loadOffersAndVacanciesUseCase()
            observeOffersAndVacancies()
        }
    }

    fun getFavoriteScreenState(): StateFlow<FavoriteScreenState> = state

    fun changeFavoriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeVacancyFavoriteStatusUseCase(vacancyId)
            loadOffersAndVacanciesUseCase()
        }
    }

    private fun observeOffersAndVacancies() {
        getFavoriteVacanciesUseCase()
            .onEach { vacancies ->
                val vacanciesUi = vacancies.map { vacancyDomainToUiMapper.map(it) }
                handleVacancies(vacanciesUi)
            }.launchIn(viewModelScope)
    }

    private fun handleVacancies(vacancies: List<VacancyUi>) {
        _state.update {
            currentVacancies.update {
                vacancies
            }
            FavoriteScreenState.Show(currentVacancies.value)
        }
    }
}

