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
fun Page_Flores() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosFlores)
    }
}

private val DatosFlores = listOf(
    Quintuple(
        R.drawable.fl_cactus,
        R.string.cactus
    ),
    Quintuple(
        R.drawable.fl_astromelia,
        R.string.astromelias
    ),
    Quintuple(

        R.drawable.fl_girasol,
        R.string.girasoles
    ),
    Quintuple(

        R.drawable.fl_orquidea,
        R.string.orquideas
    ),
    Quintuple(

        R.drawable.fl_tulipan,
        R.string.tulipanes
    ),
    Quintuple(

        R.drawable.fl_rosa,
        R.string.rosas
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }


@Preview(showBackground = true)
@Composable
fun Page_FloresPreview() {
    Page_Flores()
}