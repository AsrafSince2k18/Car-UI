package com.example.carappui.data.local

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Car(

    @DrawableRes
    val carLogo : Int,

    @DrawableRes
    val carImage : Int,

    val carColor : Color,

    val backGroundColor : Color,

    val carName : String,

    val colorName:String,

    @DrawableRes
    val userImage : List<Int>,

    val rating:Float,

    val recommended : Int,

    val rentalDay : Int,

    val rentalPrice : Int,

)
