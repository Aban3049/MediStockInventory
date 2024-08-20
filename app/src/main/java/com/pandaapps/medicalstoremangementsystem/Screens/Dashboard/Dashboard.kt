package com.pandaapps.medicalstoremangementsystem.Screens.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes
import com.pandaapps.medicalstoremangementsystem.Screens.BottomBar.Cart
import com.pandaapps.medicalstoremangementsystem.Screens.BottomBar.HomeContent
import com.pandaapps.medicalstoremangementsystem.Screens.BottomBar.Profile
import com.pandaapps.medicalstoremangementsystem.Screens.Components.list
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(userViewModel: UserViewModel, navHostController: NavHostController) {

    val context = LocalContext.current

    val navController = rememberNavController()

    val selectedItemIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
//        topBar = {
//            TopAppBar(title = {
//                Text(text = "MediStock Manager")
//            }, navigationIcon = {
//                IconButton(onClick = { navHostController.popBackStack() }) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowBackIosNew,
//                        contentDescription = "back-btn"
//                    )
//                }
//            }, modifier = Modifier.height(55.dp))
//        },
        bottomBar = {
            NavigationBar(modifier = Modifier.height(55.dp)) {
                list.fastForEachIndexed { index, item ->

                    NavigationBarItem(selected = selectedItemIndex.intValue == index, onClick = {
                        selectedItemIndex.intValue = index
                        navController.navigate(item.routes!!)
                    }, icon = {
                        Image(
                            imageVector = if (selectedItemIndex.intValue == index) item.selectedIcon else item.unSelectedIcon,
                            contentDescription = null,
                        )
                    })

                }
            }
        }

    ) {



            NavHost(startDestination = Routes.HomeHolder, navController = navController, modifier = Modifier.padding(it)) {

                composable<Routes.HomeHolder> {
                    HomeContent(navHostController)
                }
                composable<Routes.Profile> {
                    Profile()
                }

                composable<Routes.Orders> {
                    Cart(userViewModel)
                }

            }



    }

}



