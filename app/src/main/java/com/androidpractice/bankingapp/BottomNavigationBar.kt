package com.androidpractice.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androidpractice.bankingapp.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        "Home",
        Icons.Rounded.Home
    ),
    BottomNavigation(
        "Wallet",
        Icons.Rounded.Wallet
    ),
    BottomNavigation(
        "Notifications",
        Icons.Rounded.Notifications
    ),
    BottomNavigation(
        "Account",
        Icons.Rounded.AccountCircle
    )
)


@Composable
fun BottomNavigationBar() {
    NavigationBar() {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {

            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = index == 0, onClick = { /*TODO*/ }, icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title, tint = MaterialTheme.colorScheme.onBackground)
                }, label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                })
            }
        }



    }
}