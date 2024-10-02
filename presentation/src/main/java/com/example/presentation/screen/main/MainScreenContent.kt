package com.example.presentation.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.models.OfferUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.BlueButton
import com.example.presentation.uikit.FilterButton
import com.example.presentation.uikit.OfferCard
import com.example.presentation.uikit.SearchField
import com.example.presentation.uikit.VacancyCard
import com.example.presentation.utils.getVacanciesText

private const val VACANCIES_TO_SHOW = 3

@Composable
internal fun MainScreenContent(
    vacancies: List<VacancyUi>,
    offers: List<OfferUi>,
    searchValue: String,
    modifier: Modifier = Modifier,
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
    onSearchValueChange: (String) -> Unit,
    onMoreVacancy: () -> Unit,
    changeVacancyFavoriteStatus: (vacancyId: String) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(vacancies) {
        changeFavoriteCount(vacancies.count { it.isFavorite })
    }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            MainScreenSearchAndFilterRow(
                searchValue = searchValue,
                onSearchValueChange = onSearchValueChange
            )
        }
        item {
            OffersCarousel(offers, context)
        }
        item {
            VacanciesTitle()
        }
        items(vacancies.take(VACANCIES_TO_SHOW)) { vacancy ->
            VacancyCard(
                vacancy = vacancy,
                modifier = Modifier.padding(horizontal = 16.dp),
                onFavoriteIconClick = { changeVacancyFavoriteStatus(vacancy.id) }
            ) {
                navigateToVacancyDetails()
            }
        }
        item {
            if (vacancies.size > VACANCIES_TO_SHOW) {
                MoreVacanciesButton(vacancies.size - VACANCIES_TO_SHOW, onMoreVacancy, context)
            }
        }
    }
}

@Composable
private fun MainScreenSearchAndFilterRow(
    searchValue: String,
    onSearchValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SearchField(
            modifier = Modifier.weight(1f),
            value = searchValue,
            onValueChange = onSearchValueChange,
            hint = stringResource(R.string.search_field_hint),
            onAction = { /*TODO*/ }
        )
        FilterButton {
        }
    }
}

@Composable
private fun OffersCarousel(offers: List<OfferUi>, context: Context) {
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

@Composable
private fun VacanciesTitle() {
    Text(
        text = stringResource(R.string.vacancies_for_you),
        style = Typography.title2,
        color = Colors.white,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
private fun MoreVacanciesButton(vacanciesLeft: Int, onMoreVacancy: () -> Unit, context: Context) {
    BlueButton(
        onClick = onMoreVacancy,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
    ) {
        Text(
            text = stringResource(
                R.string.more_vacancies,
                getVacanciesText(context, vacanciesLeft)
            )
        )
    }
}

private fun followTheLink(context: Context, url: String) {
    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
        context.startActivity(it)
    }
}