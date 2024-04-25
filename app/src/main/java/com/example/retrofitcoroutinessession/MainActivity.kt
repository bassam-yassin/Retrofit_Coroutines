package com.example.retrofitcoroutinessession

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitcoroutinessession.ui.movies.MoviesScreen
import com.example.retrofitcoroutinessession.ui.movies.MoviesViewModel
import com.example.retrofitcoroutinessession.ui.theme.RetrofitCoroutinesSessionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        setContent {
            RetrofitCoroutinesSessionTheme {

//                val isSystemInDarkMode = isSystemInDarkTheme()
//                val systemController = rememberSystemUiController()
//
//                SideEffect {
//                    systemController.setSystemBarsColor(
//                        color = Color.Transparent,
//                        darkIcons = !isSystemInDarkMode,
//                    )
//                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoviesScreen(viewModel)
                }
            }
        }
    }
}