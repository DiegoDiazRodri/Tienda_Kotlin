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
fun Page_Lacteos() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosLacteos)
    }
}

private val DatosLacteos = listOf(
    Quintuple(
        R.drawable.lac_arequipe,
        R.string.arequipe
    ),
    Quintuple(
        R.drawable.lac_mantequilla,
        R.string.mantequilla
    ),
    Quintuple(

        R.drawable.lac_queso,
        R.string.queso
    ),
    Quintuple(

        R.drawable.lac_cuajada,
        R.string.cuajada
    ),
    Quintuple(

        R.drawable.lac_leche,
        R.string.leche
    ),
    Quintuple(

        R.drawable.lac_yogurt,
        R.string.yogurt
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_LacteosPreview() {
    Page_Lacteos()
}