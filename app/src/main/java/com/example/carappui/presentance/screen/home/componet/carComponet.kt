package com.example.carappui.presentance.screen.home.componet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carappui.R
import com.example.carappui.data.local.Car

@Composable
fun CarComponent(modifier: Modifier = Modifier,
                 car: Car) {

    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        ),
        shape = RoundedCornerShape(22.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(car.backGroundColor))
        {

            Image(painter = painterResource(id = car.carImage),
                contentDescription = null,
                modifier=Modifier
                    .offset(x=150.dp))

            Column(
                modifier=Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                CarNameAndDetails(car = car)

                CarUserListDetails(car = car)

                CarBuy(car = car)

            }

        }
    }



}


@Composable
fun CarNameAndDetails(car: Car) {

    Row (
        modifier=Modifier
            .padding(horizontal = 22.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){

        Box(modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.Black.copy(0.22f)),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = car.carLogo),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp))
        }

        Spacer(modifier = Modifier
            .width(18.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {

            Row {
                Text(text = "Color",
                    color = MaterialTheme.colorScheme.onSurface.copy(0.42f))

                Spacer(modifier = Modifier
                    .width(8.dp))

                Box(modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(car.carColor))

            }


            Text(text = car.carName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

        }


    }


}


@Composable
fun CarUserListDetails(car: Car) {

    Column (
        modifier=Modifier
            .padding(horizontal = 22.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Box {
                UserImage(car = car, index = 0)
                UserImage(
                    modifier = Modifier
                        .padding(start = 32.dp), car = car, index = 1
                )
                UserImage(
                    modifier = Modifier
                        .padding(start = 64.dp), car = car, index = 2
                )
            }

            Spacer(modifier = Modifier
                .width(8.dp))

            Text(text = car.rating.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(modifier = Modifier
            .height(12.dp))

        Text(text = "${car.recommended}% Recommend",
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
            ),
            color = MaterialTheme.colorScheme.onSurface
        )

    }

}


@Composable
fun UserImage(
    modifier: Modifier=Modifier,
    car: Car,
              index:Int) {

    Box(modifier = modifier
        .size(38.dp)
        .clip(CircleShape)
        .border(
            width = 1.dp, shape = CircleShape,
            color = Color.Black
        )){
        Image(painter =
        painterResource(id = car.userImage[index]),
            contentDescription = null,
            modifier=Modifier
                .fillMaxSize())
    }

}


@Composable
fun CarBuy(car: Car) {



    Box(modifier = Modifier
        .clip(RoundedCornerShape(topEnd = 32.dp))
        .background(MaterialTheme.colorScheme.primaryContainer)) {
        Row(
            modifier = Modifier
                .padding(horizontal = 22.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = "${car.rentalDay} day rental",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "${car.rentalPrice}.00 $",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontStyle = MaterialTheme.typography.bodyLarge.fontStyle
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

            }
            Spacer(
                modifier = Modifier
                    .width(4.dp)
            )

            Icon(
                imageVector = Icons.Rounded.ChevronRight,
                contentDescription = null
            )

        }
    }

}

@Preview
@Composable
private fun CarPr() {

    CarComponent(car=Car(
        carLogo = R.drawable.ferrarilogo,
        carImage = R.drawable.ferraricar,
        carColor = Color.Red,
        backGroundColor = MaterialTheme.colorScheme.inversePrimary,
        carName = "Ferrari",
        colorName = "Red",
        userImage = listOf(R.drawable.man1,R.drawable.man1,R.drawable.man2),
        rating = 4.3f,
        recommended = 82,
        rentalDay = 4,
        rentalPrice = 831
    ))

}
