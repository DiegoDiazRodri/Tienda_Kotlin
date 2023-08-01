package com.example.tiendakotlin.pages.Carrousel

import com.example.tiendakotlin.R


data class TrendingProduct(val name: String,  val image: Int) {
    companion object {
        val list = listOf(
            TrendingProduct("Huevos AA",  R.drawable.ic_huevos),
            TrendingProduct("Tarro de miel",  R.drawable.ic_mora),
            TrendingProduct("Mora",  R.drawable.ic_miel),
            TrendingProduct("Lechuga",  R.drawable.ic_lechuga),
            TrendingProduct("Carne",  R.drawable.ic_carne),
        )
    }
}

data class CartDataModel(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 1,

    ) {
    companion object {
        val list = listOf(
            CartDataModel(id = 101, "Huevos AA", 7000, R.drawable.ic_huevos),
            CartDataModel(id = 102, "Tarro de miel", 12000, R.drawable.ic_miel),
            CartDataModel(id = 103, "Mora", 1000, R.drawable.ic_mora),
            CartDataModel(id = 104, "Lechuga", 3000, R.drawable.ic_lechuga),
            CartDataModel(id = 105, "Carne", 5000, R.drawable.ic_carne),
        )
    }
}
