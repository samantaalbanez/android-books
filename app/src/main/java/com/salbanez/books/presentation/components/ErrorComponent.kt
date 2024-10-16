package com.salbanez.books.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorComponent() {
    Row(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Encontramos um erro, tente novamente mais tarde",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .padding(20.dp)
                .fillMaxWidth()
        )
    }
}
