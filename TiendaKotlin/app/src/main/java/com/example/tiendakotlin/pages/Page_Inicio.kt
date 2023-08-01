package com.example.tiendakotlin.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiendakotlin.R
import com.example.tiendakotlin.ui.theme.TiendaKotlinTheme


@Composable
fun Page_Inicio() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Card(modifier = Modifier
            .padding(4.dp)
            .clickable { },
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.con_1),
                    contentDescription = "noticia1"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "La Familia SENA, presente con todas sus capacidades en el gran despliegue nacional por la Guajira",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Formación, certificación, empleo, emprendimiento e impulso a energías renovables, algunas de las misiones de la Entidad para contribuir al progreso de las comunidades." +
                                "Se adelanta fase experimental de un producto nutricional maravilloso: SENHARINA." ,
                        style = MaterialTheme.typography.h6,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Ver mas")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Share"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
//        Segunda Card
        Card(modifier = Modifier
            .padding(4.dp, top = 8.dp)
            .clickable { }
            .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.con_2),
                    contentDescription = "noticia2"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Aprendiz del Amazonas representara al SENA en el campamento para jovenes lideres en EE. UU.",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "En sus 66 años de historia, el Servicio Nacional de Aprendizaje ha forjado millones de jóvenes colombianos que aportan al desarrollo de sus regiones. Marco Antonio Vela es ejemplo de ello.",
                        style = MaterialTheme.typography.h6,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Ver mas")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Share"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Card(modifier = Modifier
            .padding(4.dp, top = 8.dp)
            .clickable { }
            .fillMaxWidth(),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.con_3),
                    contentDescription = "noticia3"
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Con formacion de lideres indigenas, el SENA se compromete con el desarrollo de las regiones",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "En el Centro de Servicios de Salud de la Regional Antioquia, 70 aprendices iniciaron su proceso de formación técnica.",
                        style = MaterialTheme.typography.h6,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box() {
                            Row() {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Ver mas")
                                }
                            }
                        }
                        Box() {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorito"
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Share"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
//        Card(modifier = Modifier
//            .padding(4.dp, top = 8.dp)
//            .clickable { }
//            .fillMaxWidth(),
//            elevation = 8.dp,
//            shape = RoundedCornerShape(8.dp)
//        ) {
//            Column() {
//                Image(
//                    painter = painterResource(id = R.drawable.con_4),
//                    contentDescription = "noticia4"
//                )
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = "La musica y las artes escenicas se conectan con los antioqueños",
//                        style = MaterialTheme.typography.h4,
//                        modifier = Modifier.padding(bottom = 8.dp)
//                    )
//
//                    Text(
//                        text = "Se desarrolló un encuentro cultural y artístico con el que se busca impulsar estos crecientes sectores en el departamento.",
//                        style = MaterialTheme.typography.h6,
//                    )
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Box() {
//                            Row() {
//                                TextButton(onClick = { /*TODO*/ }) {
//                                    Text(text = "Ver mas")
//                                }
//                            }
//                        }
//                        Box() {
//                            Row() {
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Favorite,
//                                        contentDescription = "Favorito"
//                                    )
//                                }
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Share,
//                                        contentDescription = "Share"
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page_InicioPreview() {
    TiendaKotlinTheme() {
        Page_Inicio()
    }
}

