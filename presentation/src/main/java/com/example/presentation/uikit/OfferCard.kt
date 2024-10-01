package com.example.presentation.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.models.OfferUi
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography

@Composable
fun OfferCard(
    offerUi: OfferUi,
    modifier: Modifier = Modifier,
    onClick: (url: String) -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Colors.grey1, shape = RoundedCornerShape(8.dp))
            .size(width = 132.dp, height = 120.dp)
            .clickable { onClick(offerUi.link) }
            .padding(top = 10.dp, start = 8.dp, end = 12.dp, bottom = 11.dp)
    ) {
        OfferIcon(offerUi.iconType)
        OfferTitle(offerUi.title, offerUi.button != null)
        offerUi.button?.let { button ->
            OfferButton(button.text)
        }
    }
}

@Composable
private fun OfferIcon(iconType: IconType?) {
    if (iconType != null) {
        Box(
            modifier = Modifier
                .background(shape = CircleShape, color = iconType.backgroundColor)
                .size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconType.iconId),
                contentDescription = stringResource(R.string.offer_icon),
                tint = iconType.tintColor
            )
        }
    } else {
        Spacer(modifier = Modifier.size(32.dp))
    }
}

@Composable
private fun OfferTitle(title: String, hasButton: Boolean) {
    Text(
        modifier = Modifier.padding(top = 16.dp),
        text = title,
        style = Typography.title4,
        color = Colors.white,
        overflow = TextOverflow.Clip,
        maxLines = if (hasButton) 2 else 3
    )
}

@Composable
private fun OfferButton(buttonText: String) {
    Text(text = buttonText, style = Typography.text1, color = Colors.green)
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun OfferCardPreview() {
    OfferCard(
        offerUi = OfferUi(
            id = "temporary_job",
            iconType = IconType.TemporaryJob,
            title = "Временная работа и подработка",
            link = ""
        )
    ) {

    }
}

