package com.example.presentation.utils

import android.content.Context
import com.example.presentation.R

internal fun getPeopleText(context: Context, count: Int): String {
    val lastDigit = count % 10
    val lastTwoDigits = count % 100

    val word = when {
        lastTwoDigits in 11..19 -> context.getString(R.string.people) // Для чисел 11–19
        lastDigit == 1 -> context.getString(R.string.people) // Если последняя цифра 1
        lastDigit in 2..4 -> context.getString(R.string.people_two) // Если последняя цифра от 2 до 4
        else -> context.getString(R.string.people) // В остальных случаях
    }

    return context.getString(R.string.viewers_text, count, word)
}

internal fun getVacanciesText(context: Context, count: Int): String {
    val lastDigit = count % 10
    val lastTwoDigits = count % 100

    val word = when {
        lastTwoDigits in 11..19 -> context.getString(R.string.vacancies_many) // Для чисел 11–19
        lastDigit == 1 -> context.getString(R.string.vacancies_one) // Если последняя цифра 1
        lastDigit in 2..4 -> context.getString(R.string.vacancies_two) // Если последняя цифра от 2 до 4
        else -> context.getString(R.string.vacancies_many) // В остальных случаях
    }

    return "$count $word"
}

internal fun formatPublishedDate(context: Context, publishedDate: String): String {
    val dateParts = publishedDate.split("-")
    val year = dateParts[0].toInt()
    val month = dateParts[1].toInt()
    val day = dateParts[2].toInt()

    val monthName = when (month) {
        1 -> context.getString(R.string.month_january)
        2 -> context.getString(R.string.month_february)
        3 -> context.getString(R.string.month_march)
        4 -> context.getString(R.string.month_april)
        5 -> context.getString(R.string.month_may)
        6 -> context.getString(R.string.month_june)
        7 -> context.getString(R.string.month_july)
        8 -> context.getString(R.string.month_august)
        9 -> context.getString(R.string.month_september)
        10 -> context.getString(R.string.month_october)
        11 -> context.getString(R.string.month_november)
        12 -> context.getString(R.string.month_december)
        else -> ""
    }

    return context.getString(R.string.published_on, day, monthName)
}