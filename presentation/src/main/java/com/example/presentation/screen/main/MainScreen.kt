package com.example.presentation.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.R
import com.example.presentation.models.OfferUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.screen.StubScreen
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.BlueButton
import com.example.presentation.uikit.FilterButton
import com.example.presentation.uikit.MapButton
import com.example.presentation.uikit.OfferCard
import com.example.presentation.uikit.SearchField
import com.example.presentation.uikit.SearchFieldWithBackButton
import com.example.presentation.uikit.VacancyCard
import com.example.presentation.utils.getVacanciesText
import org.koin.androidx.compose.koinViewModel

private const val VACANCIES_TO_SHOW = 3

@Composable
internal fun MainScreen(
    viewModel: MainViewModel = koinViewModel(),
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
) {
    val mainScreenState by viewModel.getMainScreenState()
        .collectAsStateWithLifecycle()
    when (val state = mainScreenState) {
        MainScreenState.Initial -> StubScreen()
        is MainScreenState.Main -> MainScreenContent(
            vacancies = state.offersAndVacancies.vacancies,
            offers = state.offersAndVacancies.offers,
            searchValue = state.searchValue,
            changeFavoriteCount = changeFavoriteCount,
            navigateToVacancyDetails = navigateToVacancyDetails,
            onSearchValueChange = viewModel::changeSearchValue,
            onMoreVacancy = viewModel::toMoreVacanciesState
        )

        is MainScreenState.More -> MainScreenMoreVacanciesContent(
            vacancies = state.vacancies,
            searchValue = state.searchValue,
            changeFavoriteCount = changeFavoriteCount,
            navigateToVacancyDetails = navigateToVacancyDetails,
            onSearchValueChange = viewModel::changeSearchValue,
            onMain = viewModel::toMainState
        )
    }
}

@Composable
internal fun MainScreenContent(
    vacancies: List<VacancyUi>,
    offers: List<OfferUi>,
    searchValue: String,
    modifier: Modifier = Modifier,
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
    onSearchValueChange: (String) -> Unit,
    onMoreVacancy: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(vacancies) {
        changeFavoriteCount(vacancies.count {
            it.isFavorite
        })
    }
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SearchField(
                    modifier = Modifier.weight(1f),
                    value = searchValue,
                    onValueChange = onSearchValueChange,
                    hint = stringResource(R.string.search_field_hint),
                    onAction = { /*TODO*/ })
                FilterButton {

                }
            }
        }
        item {
            LazyRow(
                modifier = Modifier.padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(offers) { offer ->
                    OfferCard(offerUi = offer) {
                        followTheLink(context, offer.link)
                    }
                }
            }

        }
        item {
            Text(
                text = stringResource(R.string.vacancies_for_you),
                style = Typography.title2,
                color = Colors.white,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        items(vacancies.take(VACANCIES_TO_SHOW)) { vacancy ->
            VacancyCard(vacancy = vacancy, modifier = Modifier.padding(horizontal = 16.dp)) {
                navigateToVacancyDetails()
            }
        }
        item {
            if (vacancies.size > VACANCIES_TO_SHOW) {
                BlueButton(
                    onClick = onMoreVacancy,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                ) {
                    Text(
                        text = stringResource(
                            R.string.more_vacancies,
                            getVacanciesText(context, vacancies.size - VACANCIES_TO_SHOW)
                        )
                    )
                }
            }
        }
    }
}

@Composable
internal fun MainScreenMoreVacanciesContent(
    vacancies: List<VacancyUi>,
    modifier: Modifier = Modifier,
    searchValue: String,
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
    onSearchValueChange: (String) -> Unit,
    onMain: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(vacancies) {
        changeFavoriteCount(vacancies.count {
            it.isFavorite
        })
    }
    Box(modifier = modifier.padding(bottom = 8.dp)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SearchFieldWithBackButton(
                        modifier = Modifier.weight(1f),
                        value = searchValue,
                        onValueChange = onSearchValueChange,
                        hint = stringResource(R.string.search_field_hint),
                        onAction = { /*TODO*/ },
                        onBackClick = onMain
                    )
                    FilterButton {

                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = getVacanciesText(context, vacancies.size),
                        style = Typography.text1,
                        color = Colors.white
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(R.string.default_filter_parameter),
                        style = Typography.text1,
                        color = Colors.blue
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_sort),
                        contentDescription = stringResource(
                            R.string.sort
                        ),
                        tint = Colors.blue
                    )
                }
            }
            items(vacancies) { vacancy ->
                VacancyCard(
                    vacancy = vacancy,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    navigateToVacancyDetails()
                }
            }
        }
        MapButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 61.dp, start = 16.dp, end = 16.dp)
        ) {

        }
    }
}

private fun followTheLink(context: Context, url: String) {
    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
        context.startActivity(it)
    }
}