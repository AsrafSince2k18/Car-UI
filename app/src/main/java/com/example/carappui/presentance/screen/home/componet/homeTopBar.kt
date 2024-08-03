package com.example.carappui.presentance.screen.home.componet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardVoice
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {

    TopAppBar(
        modifier=modifier
            .background(Color.Transparent),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
        ),
        title = {
                SearchField(
                    modifier = Modifier
                        .padding(end=8.dp)
                )
        }

    )

}


@Composable
fun SearchField(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Trending new cars...",
                    color = MaterialTheme.colorScheme.onSurface.copy(0.32f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.KeyboardVoice,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(18.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = modifier
                .fillMaxWidth()

        )
    }

}


@Composable
fun PagerScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .height(28.dp)
        )

        Text(
            text = "LUXURIOUS\nRental Cars",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
            ),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(horizontal = 18.dp)
        )

        PagingSwipe(
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .width(8.dp)
        )


        HorDivider(
            modifier = Modifier
                .fillMaxWidth()
        )

    }

}

@Composable
fun PagingSwipe(modifier: Modifier = Modifier) {
    Spacer(
        modifier = Modifier
            .height(12.dp)
    )

    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Luxurious",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
            ),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )


        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()){
            Text(
                text = "Up Coming",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                ),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center

            )

            Spacer(modifier = Modifier
                .width(8.dp))

            Box(modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)){
                Text(text = "New",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier=Modifier
                        .padding(4.dp))
            }

        }

    }

}

@Composable
fun HorDivider(modifier: Modifier = Modifier) {

    Row (
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Divider(thickness = 2.dp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier=Modifier
                .weight(1f))
        Divider(thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(0.8f),
            modifier=Modifier
                .weight(1f))
    }

}

