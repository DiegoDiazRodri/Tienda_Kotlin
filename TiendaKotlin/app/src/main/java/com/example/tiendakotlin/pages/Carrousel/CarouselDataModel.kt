package com.example.tiendakotlin.pages.Carrousel

import androidx.compose.ui.graphics.Color
import com.example.tiendakotlin.R

data class CarouselDataModel(
    val resId: Int,
    val title: String,
    val description: String,
    val price: String,
    val color: Color,
    val aboutProduct: String = "Meet the $description TW. Inspired by the treasured franchise that brought $description cushioning to the world and laid the foundation for the aesthetic."
) {
    companion object {

        val listOfShoes = mutableListOf<CarouselDataModel>().apply {
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_aguacate,
                    title = "Vegetal",
                    description = "Aguacate",
                    price = "$ 1.000",
                    color = Color(0xFFEBD546)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_mango,
                    title = "Fruta",
                    description = "Mango",
                    price = "$ 1.000",
                    color = Color(0xFFDB5209)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_tomate,
                    title = "Vegetal",
                    description = "Tomate",
                    price = "$ 2.000",
                    color = Color(0xFFF85858)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_naranja,
                    title = "Fruta",
                    description = "Naranja",
                    price = "$ 2.500",
                    color = Color(0xFFA8AD56)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_fresa,
                    title = "Fruta",
                    description = "Fresas",
                    price = "$ 2,300",
                    color = Color(0xFF36BE64)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.ic_banana,
                    title = "Fruta",
                    description = "Banano",
                    price = "$ 5,000",
                    color = Color(0xFF0E8AB1)
                )
            )
        }

        val categories = listOf("Nuevo", "Presentado", "Tendencias")
    }

}
