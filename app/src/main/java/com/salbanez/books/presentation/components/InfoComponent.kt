package com.salbanez.books.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.salbanez.books.model.Book

@Composable
fun InfoComponent(book: Book) {
    Card(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.CenterStart)
        .padding(5.dp)
    ) {
        InfoContent(title = "Title: ", book.title)
        InfoContent(title = "Autor: ", book.author)
        InfoContent(title = "Idioma: ", book.language)
        InfoContent(title = "Numero de Paginas: ", book.pages.toString())
    }
}

@Composable
fun InfoContent(title: String, text: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = text)
    }
}
