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
fun Page_Frutas() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosFrutas)
    }
}

private val DatosFrutas = listOf(
    Quintuple(
        R.drawable.fr_fresa,
        R.string.fresa
    ),
    Quintuple(
        R.drawable.fr_mandarina,
        R.string.mandarina
    ),
    Quintuple(

        R.drawable.fr_uva,
        R.string.uvas
    ),
    Quintuple(

        R.drawable.fr_manzana,
        R.string.manzana
    ),
    Quintuple(

        R.drawable.fr_naranja,
        R.string.naranja
    ),
    Quintuple(

        R.drawable.fr_pera,
        R.string.pera
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_FrutasPreview() {
    Page_Frutas()
}