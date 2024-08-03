package com.example.carappui.presentance.screen.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carappui.presentance.screen.home.componet.HomeTopBar
import com.example.carappui.presentance.screen.home.componet.PagerScreen
import com.example.carappui.presentance.ui.theme.Purple80
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val hazeState = remember {
        HazeState()
    }

    Scaffold(
        modifier= Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection) ,
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        topBar = {
          Column {
              HomeTopBar(
                  modifier=Modifier
                      .hazeChild(hazeState)
                      .fillMaxWidth(),
                  scrollBehavior = scrollBehavior)

              PagerScreen(modifier=Modifier
                  .hazeChild(hazeState)
                  .fillMaxWidth())
          }
        }
    ) {paddingValue->
            HomeContent(
                modifier=Modifier
                    .padding(paddingValue),
                hazeState = hazeState)
    }

}

