package com.androidpractice.material3theming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.compose.Material3ThemingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3ThemingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedItem by remember {
        mutableStateOf(0)
    }

    var items = listOf("Home", "Settings", "Favorites")

    val icons = listOf(Icons.Filled.Home, Icons.Filled.Settings, Icons.Filled.Favorite)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(title = { Text(text = "Theme Demo")}, scrollBehavior = null)

        Button(onClick = { }) {
            Text("MD3 Button")
        }

        Text("A theme Demo")

        FloatingActionButton(onClick= { }) {
            Text(text = "FAB")
        }

        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = selectedItem == index, onClick = { selectedItem = index }, icon = { Icon(icons[index], contentDescription = null)  }, label = { Text(
                    text = item
                )})

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Material3ThemingTheme {
        MainScreen()
    }
}