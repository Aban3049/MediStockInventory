package com.pandaapps.medicalstoremangementsystem.Screens.BottomBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes

@Composable
fun HomeContent(navHostController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "This is Home Content")
        Button(onClick = { navHostController.navigate(Routes.PlaceOrder) }) {
            Text(text = "Place Order")
        }
    }

}