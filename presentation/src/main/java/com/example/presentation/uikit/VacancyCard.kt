package com.example.presentation.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.models.SalaryUi
import com.example.presentation.models.VacancyAddressUi
import com.example.presentation.models.VacancyExperienceUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.ColorScheme
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography

@Composable
fun VacancyCard(
    vacancy: VacancyUi,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = Colors.grey2,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
    ) {
        Icon(
            modifier = Modifier.align(Alignment.TopEnd),
            painter = painterResource(
                id = if (vacancy.isFavorite) {
                    R.drawable.icon_full_heart
                } else {
                    R.drawable.icon_favorite
                }
            ),
            contentDescription = stringResource(R.string.icon_favorite),
            tint = if (vacancy.isFavorite) {
                Colors.blue
            } else {
                Colors.grey4
            }
        )
        Column {
            //TODO склонение
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Сейчас проссматривает ${vacancy.lookingNumber} человек",
                style = Typography.text1,
                color = Colors.green
            )
            Text(
                text = vacancy.title,
                style = Typography.title3,
                color = Colors.white,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            vacancy.salary.short?.let {
                Text(
                    text = vacancy.salary.short,
                    style = Typography.title2,
                    color = Colors.white,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            Text(
                text = vacancy.address.town,
                style = Typography.text1,
                color = Colors.white,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = vacancy.company, style = Typography.text1, color = Colors.white)
                Icon(
                    painter = painterResource(id = R.drawable.icon_check),
                    contentDescription = stringResource(
                        R.string.check
                    ),
                    tint = Colors.grey3
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_experience),
                    contentDescription = stringResource(R.string.experience),
                    tint = Colors.white
                )
                Text(
                    text = vacancy.experience.previewText,
                    style = Typography.text1,
                    color = Colors.white
                )
            }
            //TODO сделать корректное отображение
            Text(
                text = vacancy.publishedDate,
                style = Typography.text1,
                modifier = Modifier.padding(bottom = 21.dp),
                color = Colors.grey3
            )
            GreenButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.respond))
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun VacancyCardPreview() {
    val vacancy = VacancyUi(
        id = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
        lookingNumber = 2,
        title = "UI/UX дизайнер",
        address = VacancyAddressUi(
            town = "Минск",
            street = "улица Бирюзова",
            house = "4/5"
        ),
        company = "Мобирикс",
        experience = VacancyExperienceUi(
            previewText = "Опыт от 1 до 3 лет",
            text = "1–3 года"
        ),
        publishedDate = "2024-02-20",
        isFavorite = false,
        salary = SalaryUi(
            full = "Уровень дохода не указан",
            short = null
        ),
        appliedNumber = 147,
        schedules = listOf("полная занятость", "полный день"),
        description = "Мы ищем специалиста на позицию UX/UI Designer, который вместе с коллегами будет заниматься проектированием пользовательских интерфейсов внутренних и внешних продуктов компании.",
        responsibilities = """
        - проектирование пользовательских сценариев и создание прототипов;
        - разработка интерфейсов для продуктов компании (Web+App);
        - работа над созданием и улучшением Дизайн-системы;
        - взаимодействие с командами frontend-разработки;
        - контроль качества внедрения дизайна;
        - ситуативно: создание презентаций и других материалов на основе фирменного стиля компании
    """.trimIndent(),
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Вакансия открыта?",
            "Какая оплата труда?"
        )
    )
    VacancyCard(vacancy = vacancy)
}