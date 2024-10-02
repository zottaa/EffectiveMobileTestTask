package com.example.presentation.uikit

import androidx.compose.ui.graphics.Color
import com.example.presentation.R
import com.example.presentation.theme.Colors

enum class IconType(
    val id: String? = null,
    val iconId: Int,
    val tintColor: Color = Color.Unspecified,
    val backgroundColor: Color = Color.Unspecified
) {
    NearVacancies(
        id = "near_vacancies",
        iconId = R.drawable.icon_near_vacancies,
        tintColor = Colors.blue,
        backgroundColor = Colors.darkBlue
    ),
    LevelUpResume(
        id = "level_up_resume",
        iconId = R.drawable.icon_level_up_resume,
        tintColor = Colors.green,
        backgroundColor = Colors.darkGreen
    ),
    TemporaryJob(
        id = "temporary_job",
        iconId = R.drawable.icon_temporary_job,
        tintColor = Colors.green,
        backgroundColor = Colors.darkGreen
    )
}