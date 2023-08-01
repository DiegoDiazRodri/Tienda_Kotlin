package com.example.tiendakotlin.pages

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiendakotlin.R
import com.example.tiendakotlin.pages.Carrousel.CarouselDataModel
import com.example.tiendakotlin.pages.Carrousel.MainViewModel
import com.example.tiendakotlin.pages.Carrousel.TrendingProduct
import com.example.tiendakotlin.ui.theme.TiendaKotlinTheme
import com.example.tiendakotlin.ui.theme.accentColor
import com.example.tiendakotlin.ui.theme.textColor
import com.example.tiendakotlin.utils.Utils
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun Page_Principal(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), true)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        HomeTopComponent(viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(10.dp))
        HomeMiddleComponent()
        Spacer(modifier = Modifier.height(6.dp))
        HomeBottomComponent()
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun HomeTopComponent(viewModel: MainViewModel) {
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    val selectedCategory = remember { mutableStateOf(CarouselDataModel.categories.size - 1) }
    val rememberScope = rememberCoroutineScope()

    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier.width(64.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarouselDataModel.categories.forEachIndexed { index, item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .height(90.dp)
                        .graphicsLayer {
                            rotationZ = -90f
                            translationX = 100f
                        }
                        .clickable {
                            selectedCategory.value = index
                            rememberScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (selectedCategory.value == index) textColor else Color.LightGray,
                    maxLines = 1,
                )
            }
        }
        com.google.accompanist.pager.HorizontalPager(
            count = CarouselDataModel.listOfShoes.size,
            contentPadding = PaddingValues(end = 70.dp),
            state = pagerState
        ) { page ->
            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
            ShoeItem(shoe = CarouselDataModel.listOfShoes[page], pageOffset, viewModel)
        }
    }
}

@Composable
fun HomeMiddleComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Text(
            text = "Favoritos",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = textColor
        )
//        Image(
//            painter = painterResource(id = R.drawable.ic_right_arrow),
//            contentDescription = "more"
//        )
    }
}

@Composable
fun HomeBottomComponent() {
    LazyRow(state = rememberLazyListState()) {
        items(TrendingProduct.list.size) { index ->
            TrendingProductItem(TrendingProduct.list[index])
        }
    }
}

@Composable
fun CategorySection() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Categorias", style = androidx.compose.material.MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "", color = androidx.compose.material.MaterialTheme.colors.primary)
            }
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryButton(
                text = "Frutass",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xffFEF4E7)
            )
            CategoryButton(
                text = "Vegetales",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xffF6FBF3)
            )
            CategoryButton(
                text = "Lacteos",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xffFFFBF3)
            )
            CategoryButton(
                text = "Carnes",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xffF6E6E9)
            )
        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun TrendingProductItem(product: TrendingProduct) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .padding(start = 16.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "shoe",
                    modifier = Modifier.padding(8.dp)
                )


//                Text(
//                    text = product.name,
//                    fontWeight = FontWeight.Medium,
//                    style = MaterialTheme.typography.labelLarge,
//                    textAlign = TextAlign.Center,
//                    color = textColor
//                )


//                Text(
//                    text = product.price,
//                    color = textColor,
//                    fontWeight = FontWeight.Medium,
//                    style = MaterialTheme.typography.labelSmall
//                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "fav",
                modifier = Modifier
                    .padding(12.dp)
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .padding(2.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_ribbon),
                contentDescription = "fav",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 4.dp, y = (-4).dp)
                    .clip(RoundedCornerShape(8.dp)),
                colorFilter = ColorFilter.tint(accentColor),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ShoeItem(shoe: CarouselDataModel, pageOffset: Float, viewModel: MainViewModel) {
    val scale = Utils.lerp(
        start = 0.5f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val angle = Utils.lerp(
        start = 30f,
        stop = 0f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val scaleXBox = Utils.lerp(
        start = 0.9f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val scaleYBox = Utils.lerp(
        start = 0.7f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val rotateY = Utils.lerp(
        start = 10f,
        stop = 0f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val boxAngle: Float by animateFloatAsState(
        targetValue = rotateY,

        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart), label = ""
    )
    val boxScaleX: Float by animateFloatAsState(
        targetValue = scaleXBox,

        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart), label = ""
    )
    val boxScaleY: Float by animateFloatAsState(
        targetValue = scaleYBox,

        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart), label = ""
    )
    val imageAngle: Float by animateFloatAsState(
        targetValue = angle,

        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart), label = ""
    )
    val visibility = Utils.lerp(
        start = 0f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )

    Box(modifier = Modifier.clickable {
        viewModel.screenState.value = MainViewModel.UiState.Details(shoe)
    }) {
        Box(
            modifier = Modifier
                .graphicsLayer {
                    Utils
                        .lerp(
                            start = 0.90f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                        .also {
                            scaleX = boxScaleX
                            scaleY = boxScaleY
                            rotationY = boxAngle
                        }
                }
                .height(280.dp)
                .width(210.dp)
                .background(color = shoe.color.copy(alpha = .8f), RoundedCornerShape(20.dp))
                .padding(end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .alpha(visibility)
            ) {
                Column {
                    Text(
                        text = shoe.title,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = shoe.description,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = shoe.price,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = .9f),
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "like",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
//            Image(
//                modifier = Modifier
//                    .padding(bottom = 16.dp)
//                    .size(24.dp)
//                    .align(Alignment.BottomEnd),
//                painter = painterResource(id = R.drawable.ic_right_arrow),
//                contentDescription = "go to next",
//                colorFilter = ColorFilter.tint(Color.White),
//            )
        }
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(220.dp)
        ) {

            Image(
                painter = painterResource(id = shoe.resId),
                contentDescription = "",
                modifier = Modifier
                    .height(340.dp)
                    .align(
                        Alignment.Center
                    )
                    .rotate(330f)
                    .offset(x = 20.dp, y = 10.dp)
                    .size(320.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        rotationZ = imageAngle
                    },
                contentScale = ContentScale.Fit
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Page_PrincipalPreview() {
    TiendaKotlinTheme() {
        Page_Principal(viewModel = MainViewModel())
    }
}