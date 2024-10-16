package com.salbanez.books.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.salbanez.books.model.Book

private const val IMAGE_URL = "https://raw.githubusercontent.com/benoitvallon/100-best-books/refs/heads/master/static/"

@Composable
fun CardView(book: Book, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke() }
    ) {
        TitleCard(book.title)
        Column {
            ImageCard(image = IMAGE_URL+book.imageLink)
        }
    }
}

@Composable
fun ImageCard(image: String) {
    val painter = rememberImagePainter(data = image)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(200.dp)
            .padding(start = 10.dp)
    )
}

@Composable
fun TitleCard(title: String) {
    Row {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
    }
}
