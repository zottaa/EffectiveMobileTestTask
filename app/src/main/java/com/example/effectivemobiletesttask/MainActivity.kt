package com.example.effectivemobiletesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.models.OfferButtonUi
import com.example.presentation.models.OfferUi
import com.example.presentation.models.SalaryUi
import com.example.presentation.models.VacancyAddressUi
import com.example.presentation.models.VacancyExperienceUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.EffectiveMobileTestTaskTheme
import com.example.presentation.uikit.IconType
import com.example.presentation.uikit.OfferCard
import com.example.presentation.uikit.SearchField
import com.example.presentation.uikit.SearchFieldPreview
import com.example.presentation.uikit.VacancyCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileTestTaskTheme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(top = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
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
                            isFavorite = true,
                            salary = SalaryUi(
                                full = "Уровень дохода не указан",
                                short = "50000 рублей на руки"
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
                        VacancyCard(
                            vacancy = vacancy,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}