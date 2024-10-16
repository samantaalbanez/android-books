package com.salbanez.books.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingComponent() {
    Row(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(100.dp)
                .wrapContentSize(Alignment.Center)
                .fillMaxWidth(),
            color = Color.Blue,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}
