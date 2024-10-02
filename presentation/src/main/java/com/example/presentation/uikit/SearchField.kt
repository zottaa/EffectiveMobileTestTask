package com.example.presentation.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.presentation.R
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography

@Composable
internal fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Unspecified,
    onAction: () -> Unit,
    minLines: Int = 1,
    enabled: Boolean = true,
    leadingIconId: Int? = R.drawable.icon_search,
) {
    val hintColor = if (value.isEmpty()) {
        Colors.grey4
    } else {
        Color.Transparent
    }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        minLines = minLines,
        textStyle = Typography.text1.copy(color = Colors.white),
        interactionSource = interactionSource,
        keyboardActions = KeyboardActions(
            onDone = {
                onAction()
            }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        decorationBox = { content ->
            Row(
                Modifier
                    .background(
                        color = Colors.grey2, RoundedCornerShape(8.dp)
                    )
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                leadingIconId?.let {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = leadingIconId),
                        contentDescription = stringResource(R.string.search),
                        tint = hintColor
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    content()
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            color = hintColor,
                            style = Typography.text1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    )
}

@Composable
internal fun SearchFieldWithBackButton(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Unspecified,
    onAction: () -> Unit,
    minLines: Int = 1,
    enabled: Boolean = true,
    leadingIconId: Int? = R.drawable.icon_left_arrow,
    onBackClick: () -> Unit
) {
    val hintColor = if (value.isEmpty()) {
        Colors.grey4
    } else {
        Color.Transparent
    }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        minLines = minLines,
        textStyle = Typography.text1.copy(color = Colors.white),
        interactionSource = interactionSource,
        keyboardActions = KeyboardActions(
            onDone = {
                onAction()
            }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        decorationBox = { content ->
            Row(
                Modifier
                    .background(
                        color = Colors.grey2, RoundedCornerShape(8.dp)
                    )
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                leadingIconId?.let {
                    Icon(
                        modifier = Modifier.size(24.dp).clickable {
                            onBackClick()
                        },
                        painter = painterResource(id = leadingIconId),
                        contentDescription = stringResource(R.string.back),
                        tint = Colors.white
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    content()
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            color = hintColor,
                            style = Typography.text1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun SearchFieldPreview() {
    Column {
        SearchField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {

            },
            hint = "Должность, ключевые слова",
            onAction = { })
    }
}