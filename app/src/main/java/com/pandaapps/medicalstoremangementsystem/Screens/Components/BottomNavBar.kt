package com.pandaapps.medicalstoremangementsystem.Screens.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes

val list = listOf(

    BottomNavBarItems(
        Icons.Filled.Home,
        Icons.Outlined.Home,
        routes = Routes.HomeHolder
    ),

    BottomNavBarItems(
        Icons.Filled.ShoppingCart,
        Icons.Outlined.ShoppingCart,
        routes = Routes.Orders
    ),

    BottomNavBarItems(
        Icons.Filled.Person,
        Icons.Outlined.Person,
        routes = Routes.Profile
    ),


    )

data class BottomNavBarItems(
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val routes: Routes? = null
)