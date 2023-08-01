package com.example.tiendakotlin.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendakotlin.R
import com.example.tiendakotlin.components.DrawableStringQuintuple
import com.example.tiendakotlin.components.Filas
import com.example.tiendakotlin.components.Quintuple

@Composable
fun Page_Verduras() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosVerduras)
    }
}

private val DatosVerduras = listOf(
    Quintuple(
        R.drawable.ver_cebolla,
        R.string.cebolla
    ),
    Quintuple(
        R.drawable.ver_aguacate,
        R.string.aguacate
    ),
    Quintuple(

        R.drawable.ver_lechuga,
        R.string.lechuga
    ),
    Quintuple(

        R.drawable.ver_tomate,
        R.string.tomate
    ),
    Quintuple(

        R.drawable.ver_pimenton,
        R.string.pimenton
    ),
    Quintuple(

        R.drawable.ver_zanahoria,
        R.string.zanahoria
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_VerdurasPreview() {
    Page_Verduras()
}