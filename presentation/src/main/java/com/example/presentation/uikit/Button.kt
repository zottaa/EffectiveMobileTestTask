package com.example.presentation.uikit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography

@Composable
fun BlueButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    paddingValues: PaddingValues = PaddingValues(
        start = 146.dp,
        end = 145.dp,
        top = 14.dp,
        bottom = 13.dp
    ),
    content: @Composable RowScope.() -> Unit
) {
    CompositionLocalProvider(
        LocalTextStyle provides Typography.buttonText1
    ) {
        Button(
            modifier = modifier,
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            enabled = enabled,
            contentPadding = paddingValues,
            colors = ButtonColors(
                contentColor = Colors.white,
                containerColor = Colors.blue,
                disabledContentColor = Colors.grey4,
                disabledContainerColor = Colors.darkBlue,
            ),
            content = content
        )
    }
}

@Composable
fun GreenButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    paddingValues: PaddingValues = PaddingValues(
        top = 7.dp,
        bottom = 7.dp
    ),
    content: @Composable RowScope.() -> Unit
) {
    CompositionLocalProvider(
        LocalTextStyle provides Typography.buttonText2
    ) {
        Button(
            modifier = modifier,
            onClick = onClick,
            shape = RoundedCornerShape(50.dp),
            enabled = enabled,
            contentPadding = paddingValues,
            colors = ButtonColors(
                contentColor = Colors.white,
                containerColor = Colors.green,
                disabledContentColor = Colors.grey4,
                disabledContainerColor = Colors.darkGreen,
            ),
            content = content
        )
    }
}

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledIconButton(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        colors = IconButtonColors(
            containerColor = Colors.grey2,
            contentColor = Colors.white,
            disabledContentColor = Colors.grey4,
            disabledContainerColor = Colors.grey2
        )
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.icon_filter),
            contentDescription = stringResource(
                R.string.filter
            )
        )
    }
}

@Composable
fun MapButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
        colors = ButtonColors(
            containerColor = Colors.grey2,
            contentColor = Colors.white,
            disabledContentColor = Colors.grey4,
            disabledContainerColor = Colors.grey2
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icon_map),
                contentDescription = stringResource(
                    R.string.filter
                )
            )
            Text(text = "Карта")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BlueButton(
            onClick = {

            }
        ) {
            Text("Label")
        }
        BlueButton(
            enabled = false,
            onClick = {

            }
        ) {
            Text("Label")
        }
        GreenButton(
            onClick = {

            }
        ) {
            Text("Label")
        }
        GreenButton(
            enabled = false,
            onClick = {

            }
        ) {
            Text("Label")
        }
        FilterButton {

        }
        MapButton {

        }
    }
}