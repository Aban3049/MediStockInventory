package com.pandaapps.medicalstoremangementsystem.Screens.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontFamily: FontFamily = FontFamily.Default
) {

    Text(
        text,
        modifier = modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.displayMedium,
        textAlign = textAlign,
        fontFamily = fontFamily
    )

}

@Preview(showSystemUi = true)
@Composable

fun PreviewHeaderText() {
    HeaderText(text = "LogIn")
}