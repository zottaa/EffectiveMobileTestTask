package com.example.presentation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.presentation.models.OfferButtonUi
import com.example.presentation.models.OfferUi
import com.example.presentation.models.SalaryUi
import com.example.presentation.models.VacancyAddressUi
import com.example.presentation.models.VacancyExperienceUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.navigation.BottomTabDestinations
import com.example.presentation.navigation.Screens
import com.example.presentation.screen.FavoriteScreenContent
import com.example.presentation.screen.MainScreenContent
import com.example.presentation.screen.StubScreen
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.IconType

val offers = listOf(
    OfferUi(
        id = "near_vacancies",
        iconType = IconType.NearVacancies,
        title = "Вакансии рядом с вами",
        link = "https://hh.ru/"
    ),
    OfferUi(
        id = "level_up_resume",
        iconType = IconType.LevelUpResume,
        title = "Поднять резюме в поиске",
        button = OfferButtonUi(text = "Поднять"),
        link = "https://hh.ru/mentors?from=footer_new&hhtmFromLabel=footer_new&hhtmFrom=main&purposeId=1"
    ),
    OfferUi(
        id = "temporary_job",
        iconType = IconType.TemporaryJob,
        title = "Временная работа или подработка",
        link = "https://hh.ru/"
    ),
    OfferUi(
        title = "Полезные статьи и советы",
        link = "https://hh.ru/articles?hhtmFrom=main"
    )
)
val vacancies = listOf(
    // Вакансия 1
    VacancyUi(
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
        responsibilities = "- проектирование пользовательских сценариев и создание прототипов;\n- разработка интерфейсов для продуктов компании (Web+App);\n- работа над созданием и улучшением Дизайн-системы;\n- взаимодействие с командами frontend-разработки;\n- контроль качества внедрения дизайна;\n- ситуативно: создание презентаций и других материалов на основе фирменного стиля компании",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Вакансия открыта?",
            "Какая оплата труда?"
        )
    ),
    // Вакансия 2
    VacancyUi(
        id = "54a876a5-2205-48ba-9498-cfecff4baa6e",
        lookingNumber = 17,
        title = "UI/UX-дизайнер / Web-дизайнер / Дизайнер интерфейсов",
        address = VacancyAddressUi(
            town = "Казань",
            street = "улица Чистопольская",
            house = "20/10"
        ),
        company = "Шафигуллин Шакир",
        experience = VacancyExperienceUi(
            previewText = "Опыт от 1 до 3 лет",
            text = "1–3 года"
        ),
        publishedDate = "2024-03-06",
        isFavorite = false,
        salary = SalaryUi(
            full = "от 20 000 до 50 000 ₽ на руки",
            short = "20 000 до 50 000 ₽"
        ),
        appliedNumber = 17,
        schedules = listOf("частичная занятость", "полный день"),
        description = "Мы разрабатываем мобильные приложения, web-приложения и сайты под ключ.\n\nНам в команду нужен UX/UI Designer!",
        responsibilities = "- Разработка дизайна Web+App (обязательно Figma)\n\n- Работа над созданием и улучшением систем;\n\n- Взаимодействие с командами frontend-разработки и backend-разработки",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Как с вами связаться?"
        )
    ),
    // Вакансия 3
    VacancyUi(
        id = "75c84407-52e1-4cce-a73a-ff2d3ac031b3",
        title = "UX/UI Designer",
        address = VacancyAddressUi(
            town = "Казань",
            street = "улица Пушкина",
            house = "2"
        ),
        company = "Aston",
        experience = VacancyExperienceUi(
            previewText = "Опыт от 3 до 6 лет",
            text = "3–6 лет"
        ),
        publishedDate = "2024-02-28",
        isFavorite = true,
        salary = SalaryUi(
            full = "Уровень дохода не указан",
            short = null
        ),
        appliedNumber = 11,
        schedules = listOf("полная занятость", "удаленная работа"),
        description = "Мы – аутсорсинговая аккредитованная IT-компания Aston, разрабатываем программное обеспечение на заказ и оказываем услуги IT-аутсорсинга предприятиям, организациям и стартапам. Приоритетные направления – финансовые технологии, телеком, ритейл, недвижимость и другие.",
        responsibilities = "- совместно с Product Owner определять бизнес-метрики, потребности клиентов банка, фиксировать их в формате задач и метрик успешности;\n- изучать лучшие практики и недостатки аналогичных продуктов;\n- создавать прототипы для проверки гипотез;\n- передавать прототипы на Usability-тесты и контролировать их проведение;\n- улучшать решения по результатам тестов и наблюдений;\n- готовить чистовые макеты на основе компонентов дизайн-системы банка для передачи в разработку;\n- создавать и описывать новые компоненты дизайн-системы по принятым в банке стандартам;\n- передавать макеты разработчикам и отвечать на возникающие в процессе разработки вопросы.",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Какая оплата труда?"
        )
    ),
    // Вакансия 4
    VacancyUi(
        id = "16f88865-ae74-4b7c-9d85-b68334bb97db",
        lookingNumber = 57,
        title = "Веб-дизайнер",
        address = VacancyAddressUi(
            town = "Казань",
            street = "улица Пушкина",
            house = "57"
        ),
        company = "Алабуга. Маркетинг и PR",
        experience = VacancyExperienceUi(
            previewText = "Без опыта",
            text = "не требуется"
        ),
        publishedDate = "2024-03-02",
        isFavorite = false,
        salary = SalaryUi(
            full = "от 60 000 ₽ до вычета налогов",
            short = "от 60 000 ₽"
        ),
        appliedNumber = 7,
        schedules = listOf("частичная занятость", "полный день"),
        description = "- Разработка новых сайтов, приложений, лэндингов;\n- Создание и доработка прототипов готовых к сдаче в верстку;\n- Взаимодействие с подрядчиками по разработке сайтов;\n- Доработка существующих сайтов;\n- Проектирование интерфейсов, организация UI/UX-исследований;\n- Взаимодействие с Frontend и Backend разработчиками, техническими специалистами.",
        responsibilities = "- Разработка сайтов;\n- Работа с дизайн системой;\n- Взаимодействие с командой разработчиков.",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Вакансия открыта?",
            "Какая оплата труда?"
        )
    ),
    // Вакансия 5
    VacancyUi(
        id = "26f88856-ae74-4b7c-9d85-b68334bb97db",
        lookingNumber = 29,
        title = "Ведущий продуктовый дизайнер",
        address = VacancyAddressUi(
            town = "Минск",
            street = "проспект Хасанова",
            house = "15"
        ),
        company = "ПАО Ростелеком",
        experience = VacancyExperienceUi(
            previewText = "Опыт от 3 до 6 лет",
            text = "3–6 лет"
        ),
        publishedDate = "2024-02-19",
        isFavorite = false,
        salary = SalaryUi(
            full = "Уровень дохода не указан",
            short = null
        ),
        appliedNumber = 29,
        schedules = listOf("полная занятость", "удаленная работа"),
        description = "Перед вами не просто вакансия. Перед вами — уникальные возможности, от которых вас отделяет всего один клик.",
        responsibilities = "- Готовить макеты на основании прототипа и/или описания пользовательских сценариев;\n— Анализировать бизнесовые и пользовательские требования, уточнять постановки от аналитиков и проектировщиков;\n— Создавать графические и стилистические элементы для портала, приложений и промо страниц;\n— Оптимизировать дизайн существующих интерфейсов.",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Вакансия открыта?",
            "Какая оплата труда?"
        )
    ),
    // Вакансия 6
    VacancyUi(
        id = "15f88865-ae74-4b7c-9d81-b78334bb97db",
        lookingNumber = 1,
        title = "Product Designer",
        address = VacancyAddressUi(
            town = "Минск",
            street = "улица Побратимова",
            house = "5"
        ),
        company = "TravelLine",
        experience = VacancyExperienceUi(
            previewText = "Опыт от 3 до 6 лет",
            text = "3–6 лет"
        ),
        publishedDate = "2024-03-20",
        isFavorite = true,
        salary = SalaryUi(
            full = "от 150 000 до 200 000 ₽ до вычета налогов",
            short = "150 000 до 200 000 ₽"
        ),
        appliedNumber = 12,
        schedules = listOf("полная занятость", "полный день"),
        description = "Мы разрабатываем продукты для автоматизации работы гостиничного бизнеса. Наши инструменты помогают управляющим, сотрудникам отелей и туристическим агентствам улучшать качество обслуживания гостей, а также управлять продажами номеров, бронированием и другими процессами.",
        responsibilities = "- Проектировать пользовательские интерфейсы продуктов для гостиничного бизнеса;\n- Взаимодействовать с разработчиками и бизнес-аналитиками;\n- Участвовать в улучшении существующих продуктов и создании новых функциональностей.",
        questions = listOf(
            "Где располагается место работы?",
            "Какой график работы?",
            "Как с вами связаться?"
        )
    )
)

@Composable
fun EffectiveMobileTestTaskApp() {
    val navController = rememberNavController()
    var favoriteCount by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Colors.black,
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            var navigationSelectedItem by rememberSaveable {
                mutableStateOf(0)
            }
            val bottomTabDestinations = listOf(
                BottomBarItem(
                    destination = BottomTabDestinations.Search,
                    icon = R.drawable.icon_search,
                    label = stringResource(R.string.search_label)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Favorite,
                    icon = R.drawable.icon_favorite,
                    label = stringResource(R.string.favorite)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Responses,
                    icon = R.drawable.icon_responses,
                    label = stringResource(R.string.responses)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Messages,
                    icon = R.drawable.icon_messages,
                    label = stringResource(R.string.messages)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Profile,
                    icon = R.drawable.icon_profile,
                    label = stringResource(R.string.profile)
                )
            )

            LaunchedEffect(navBackStackEntry) {
                navBackStackEntry?.destination?.route?.let { destination ->
                    navigationSelectedItem =
                        bottomTabDestinations.indexOfFirst { it.destination::class.qualifiedName == destination }
                }
            }

            NavigationBar(
                containerColor = Colors.black,
            ) {
                bottomTabDestinations.forEachIndexed { index, bottomTabItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(bottomTabItem.destination) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                            Text(text = bottomTabItem.label, style = Typography.tabText)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (needToShowBubble(bottomTabItem, favoriteCount)) {
                                        Badge(
                                            modifier = Modifier.size(13.dp).offset(x = 3.dp, y = (-1).dp),
                                            containerColor = Colors.red,
                                            contentColor = Colors.white
                                        ) {
                                            Text("$favoriteCount", style = Typography.number)
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = bottomTabItem.icon),
                                    contentDescription = bottomTabItem.label
                                )
                            }
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = Colors.blue,
                            selectedTextColor = Colors.blue,
                            selectedIndicatorColor = Color.Transparent,
                            unselectedIconColor = Colors.grey4,
                            unselectedTextColor = Colors.grey4,
                            disabledIconColor = Colors.grey4,
                            disabledTextColor = Colors.grey4
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomTabDestinations.Search,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable<BottomTabDestinations.Search> {
                val searchNavController = rememberNavController()
                NavHost(navController = searchNavController, startDestination = Screens.Main) {
                    composable<Screens.Main> {
                        MainScreenContent(
                            vacancies = vacancies,
                            offers = offers,
                            changeFavoriteCount = { newFavoriteCountValue ->
                                favoriteCount = newFavoriteCountValue
                            }
                        ) {
                            searchNavController.navigate(Screens.Stub)
                        }
                    }
                    composable<Screens.Stub> {
                        StubScreen()
                    }
                }
            }
            composable<BottomTabDestinations.Favorite> {
                val favoriteNavController = rememberNavController()
                NavHost(
                    navController = favoriteNavController,
                    startDestination = Screens.Favorite
                ) {
                    composable<Screens.Favorite> {
                        FavoriteScreenContent(
                            favoriteVacancies = vacancies.filter { it.isFavorite },
                            changeFavoriteCount = { newFavoriteCountValue ->
                                favoriteCount = newFavoriteCountValue
                            }
                        ) {
                            favoriteNavController.navigate(Screens.Stub)
                        }
                    }
                    composable<Screens.Stub> {
                        StubScreen()
                    }
                }
            }
            composable<BottomTabDestinations.Profile> {
                val profileNavController = rememberNavController()
                StubNavHost(navController = profileNavController)
            }
            composable<BottomTabDestinations.Messages> {
                val messagesNavController = rememberNavController()
                StubNavHost(navController = messagesNavController)
            }
            composable<BottomTabDestinations.Responses> {
                val responsesNavController = rememberNavController()
                StubNavHost(navController = responsesNavController)
            }
        }
    }
}

@Composable
private fun needToShowBubble(
    bottomTabItem: BottomBarItem,
    favoriteCount: Int
) = bottomTabItem.destination is BottomTabDestinations.Favorite && favoriteCount > 0

internal data class BottomBarItem(
    val destination: BottomTabDestinations,
    val icon: Int,
    val label: String
)

@Composable
private fun StubNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Stub) {
        composable<Screens.Stub> {
            StubScreen()
        }
    }
}