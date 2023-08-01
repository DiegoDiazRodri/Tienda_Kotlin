package com.example.tiendakotlin.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    menuItem: List<MenuItem>
) {
    var showMenu by remember{
        mutableStateOf(false)
    }
    var  currentRoute = Current_Route(navController = navController)
    var mytitle = "Tienda cba sena"
    menuItem.forEach { item ->
        if (currentRoute == item.ruta) mytitle = item.title
    }
    TopAppBar (
        title = { Text(text = mytitle) },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Icono de Menu"
                )
            }
        }
    )
}

