package com.example.tiendakotlin.pages.Login.screens


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiendakotlin.components.MainPage
import com.example.tiendakotlin.components.MenuItem
import com.example.tiendakotlin.pages.Login.LoginScreen
import com.example.tiendakotlin.pages.Login.animations.SplashScreen

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Pantallas.SplashScreen.route) {
        composable(Pantallas.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Pantallas.LogIn.route) {
            LoginScreen(navController)
        }
        composable(route = MenuItem.Page1.ruta){
            MainPage()
        }
    }
}