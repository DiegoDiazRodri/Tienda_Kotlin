package com.example.dashboard_v2.pages

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
fun Page_Ver_Mas() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosVerMas)
    }
}

private val DatosVerMas = listOf(
    Quintuple(
        R.drawable.verm_huevos,
        R.string.huevos,
    ),
    Quintuple(
        R.drawable.fl_astromelia,
        R.string.astromelias
    ),
    Quintuple(

        R.drawable.lac_queso,
        R.string.queso
    ),
    Quintuple(

        R.drawable.verm_gulupa,
        R.string.gulupa
    ),
    Quintuple(

        R.drawable.lac_leche,
        R.string.leche
    ),
    Quintuple(

        R.drawable.ver_pimenton,
        R.string.pimenton
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_Ver_MasPreview() {
    Page_Ver_Mas()
}