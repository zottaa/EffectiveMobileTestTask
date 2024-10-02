package com.example.presentation.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.FilterButton
import com.example.presentation.uikit.MapButton
import com.example.presentation.uikit.SearchFieldWithBackButton
import com.example.presentation.uikit.VacancyCard
import com.example.presentation.utils.getVacanciesText

@Composable
internal fun MainScreenMoreVacanciesContent(
    vacancies: List<VacancyUi>,
    modifier: Modifier = Modifier,
    searchValue: String,
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
    onSearchValueChange: (String) -> Unit,
    changeVacancyFavoriteStatus: (vacancyId: String) -> Unit,
    onMain: () -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(vacancies) {
        changeFavoriteCount(vacancies.count { it.isFavorite })
    }

    Box(modifier = modifier.padding(bottom = 8.dp)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                MoreScreenSearchAndFilterRow(
                    searchValue = searchValue,
                    onSearchValueChange = onSearchValueChange,
                    onMain = onMain
                )
            }
            item {
                VacanciesHeader(context, vacancies)
            }
            items(vacancies) { vacancy ->
                VacancyCard(
                    vacancy = vacancy,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onFavoriteIconClick = { changeVacancyFavoriteStatus(vacancy.id) }
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

@Composable
private fun MoreScreenSearchAndFilterRow(
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
    onMain: () -> Unit
) {
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

@Composable
private fun VacanciesHeader(context: Context, vacancies: List<VacancyUi>) {
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
            contentDescription = stringResource(R.string.sort),
            tint = Colors.blue
        )
    }
}

