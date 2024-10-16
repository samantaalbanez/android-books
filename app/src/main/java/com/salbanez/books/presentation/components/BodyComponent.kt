package com.salbanez.books.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.salbanez.books.viewmodel.BookUiState
import com.salbanez.books.viewmodel.BooksViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, onClick: (() -> Unit)? = null) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.DarkGray
        ),
        navigationIcon = {
            onClick?.let {
                IconButton(onClick = { onClick.invoke() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
            }
        }
    )
}

@Composable
fun ContentHomeView(booksViewModel: BooksViewModel, padding: PaddingValues, navController: NavController) {
    val uiState = booksViewModel.bookUiState.collectAsState()
    val state = uiState.value

    when (state) {
        is BookUiState.LoadBooks -> {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(state.books) { book ->
                    CardView(book = book) {
                        navController.navigate("DetailView/${book.title}")
                        booksViewModel.getBook(title = book.title)
                    }
                }
            }
        }
        is BookUiState.ShowError -> ErrorComponent()
        is BookUiState.Loading -> LoadingComponent()
    }
}
