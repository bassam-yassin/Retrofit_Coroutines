package com.example.retrofitcoroutinessession.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitcoroutinessession.ui.composable.Error
import com.example.retrofitcoroutinessession.ui.composable.ImageNetwork
import com.example.retrofitcoroutinessession.ui.composable.Loading
import com.example.retrofitcoroutinessession.ui.theme.Black100

@Composable
fun MoviesScreen(viewModel: MoviesViewModel) {
    val state by viewModel.state.collectAsState()
    MoviesScreenContent(state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreenContent(state: MoviesUIState) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Black100
    ) { paddingValues ->
        Loading(state = state.isLoading)
        Error(state = state.isError)
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            Text(
                text = "Popular Movies",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp,),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(state.movies) { movie ->
                    Card(
                        modifier = Modifier.fillMaxWidth().height(200.dp).padding(bottom = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            ImageNetwork(
                                modifier = Modifier.fillMaxSize(),
                                imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
                            )
                            Text(
                                text = movie.title,
                                color = Color.White,
                                modifier = Modifier.fillMaxWidth().padding(8.dp)
                                    .align(Alignment.BottomStart),
                            )
                        }
                    }
                }
            }
        }
    }
}