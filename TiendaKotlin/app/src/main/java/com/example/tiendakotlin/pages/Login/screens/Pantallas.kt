package com.example.tiendakotlin.pages.Login.screens

sealed class Pantallas(val route: String) {
    object SplashScreen: Pantallas("Splash_Screen")
    object LogIn: Pantallas("Pantalla_LogIn")
}