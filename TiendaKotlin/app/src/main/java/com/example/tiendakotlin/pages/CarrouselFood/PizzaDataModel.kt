package com.example.tiendakotlin.pages.CarrouselFood

import com.example.tiendakotlin.R


data class PizzaDataModel(val pizzaName: String, val pizzaImage: Int, val pizzaPrice: String) {
    companion object {
        val list = listOf(
            PizzaDataModel("Ensalada de verduras", R.drawable.bowl_veggies_2, "$16.000"),
            PizzaDataModel("Ensalada de frutas", R.drawable.bowl_fruits, "$12.000"),
            PizzaDataModel("Tazón de desayuno rápido", R.drawable.bowl_veggies_1, "$15.000"),
            PizzaDataModel("Tazón de tostadas de aguacate", R.drawable.bowl_veggies_3, "$20.000"),
            PizzaDataModel("Súper tazón de brócoli", R.drawable.bowl_veggies_4, "$27.000"),
            PizzaDataModel("Pizza crujiente y con queso", R.drawable.bowl_veggies_5, "$20.000"),
        )
    }
}
