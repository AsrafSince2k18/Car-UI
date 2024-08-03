package com.example.carappui.presentance.screen.home.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.StackedBarChart
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.carappui.R
import com.example.carappui.data.local.Car
import com.example.carappui.presentance.screen.home.componet.CarComponent
import com.example.carappui.presentance.ui.theme.PurpleGrey40
import com.example.carappui.presentance.ui.theme.PurpleGrey80
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
) {

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {

        CarList(
            modifier = Modifier

                .haze(
                    state = hazeState,
                    style = HazeStyle(
                        tint = MaterialTheme.colorScheme.surfaceTint.copy(0.6f),
                        blurRadius = 13.dp
                    ),

                    )
                .fillMaxSize()
        )


        CustomBottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
                .hazeChild(hazeState,
                    shape = RoundedCornerShape(18.dp),
                )
                .align(Alignment.BottomStart)
        )


    }

}

@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
) {
    //bottom

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarIcon(
            imageVector = Icons.Rounded.Home,
            selected = true
        )
        BottomBarIcon(
            imageVector = Icons.Rounded.StackedBarChart,
            selected = false
        )
        BottomBarIcon (
                imageVector = Icons.Rounded.Subscriptions,
        selected = false
        )
        BottomBarIcon(
        imageVector = Icons.Rounded.Settings,
        selected = false
    )


    }

}


@Composable
fun BottomBarIcon(
    imageVector: ImageVector,
    selected: Boolean
) {

    Box(
        modifier = Modifier
            .border(
                border = if (selected) BorderStroke(width = 2.dp, color = Color.White)
                else BorderStroke(width = 0.dp, color = Color.Transparent),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(4.dp)
        )
    }

}


@Composable
fun CarList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 12.dp,
            end = 12.dp,
            bottom = 60.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(carItem) {
            CarComponent(
                car = it,
                modifier = modifier
            )
        }
    }
}


val carItem = listOf(
    Car(
        carLogo = R.drawable.ferrarilogo,
        carImage = R.drawable.ferraricar,
        carColor = Color.Red,
        backGroundColor = PurpleGrey80,
        carName = "Ferrari",
        colorName = "Red",
        userImage = listOf(R.drawable.man1, R.drawable.man1, R.drawable.man2),
        rating = 4.3f,
        recommended = 82,
        rentalDay = 4,
        rentalPrice = 831

    ),
    Car(
        carLogo = R.drawable.bmwlogo,
        carImage = R.drawable.bmw,
        carColor = Color.Black,
        backGroundColor = PurpleGrey40,
        carName = "Bmw",
        colorName = "Red",
        userImage = listOf(R.drawable.man1, R.drawable.man1, R.drawable.man2),
        rating = 4.3f,
        recommended = 82,
        rentalDay = 4,
        rentalPrice = 831

    ),
    Car(
        carLogo = R.drawable.lamborghinilogo,
        carImage = R.drawable.lamborghini,
        carColor = Color.Yellow,
        backGroundColor = Color.Yellow.copy(0.12f),
        carName = "Lamborghini",
        colorName = "Yellow",
        userImage = listOf(R.drawable.man1, R.drawable.man1, R.drawable.man2),
        rating = 4.3f,
        recommended = 82,
        rentalDay = 4,
        rentalPrice = 831
    ),
    Car(
        carLogo = R.drawable.porschelogo,
        carImage = R.drawable.porsche,
        carColor = Color.Yellow,
        backGroundColor = Color.Yellow.copy(0.32f),
        carName = "Porsche",
        colorName = "Yellow",
        userImage = listOf(R.drawable.man2, R.drawable.man1, R.drawable.man2),
        rating = 4.3f,
        recommended = 82,
        rentalDay = 4,
        rentalPrice = 831
    )

)


