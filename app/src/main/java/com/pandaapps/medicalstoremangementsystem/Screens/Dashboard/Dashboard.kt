package com.pandaapps.medicalstoremangementsystem.Screens.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
        topBar = {
            TopAppBar(title = {
                Text(text = "MediStock Manager")
            }, navigationIcon = {
                IconButton(onClick = { navHostController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "back-btn"
                    )
                }
            })
        },
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

        Column(Modifier.padding(it)) {

            NavHost(startDestination = Routes.HomeHolder, navController = navController) {

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

}

//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
//            .background(
//                color = Color(android.graphics.Color.parseColor("#f8eeec"))
//            )
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//
//        ConstraintLayout {
//
//            val (topImg, profile) = createRefs()
//
//            Box(modifier = Modifier
//                .fillMaxWidth()
//                .height(245.dp)
//                .constrainAs(topImg) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//                .background(
//                    brush = Brush.horizontalGradient(
//                        colors = listOf(
//                            Color(android.graphics.Color.parseColor("#EA6D35")),
//                            Color(android.graphics.Color.parseColor("#3B608C"))
//                        )
//                    ), shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
//
//                )
//
//
//            )
//
//
//            Row(
//                modifier = Modifier
//                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
//                    .fillMaxWidth()
//            ) {
//
//                Column(
//                    modifier = Modifier
//                        .height(100.dp)
//                        .padding(start = 14.dp)
//                        .weight(0.7f),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.Start
//                ) {
//                    Text(text = "Hello", color = Color.White, fontSize = 18.sp)
//
//                    Text(
//                        text = "Muhammad Aban",
//                        color = Color.White,
//                        fontSize = 22.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(top = 14.dp)
//                    )
//                }
//
//                Image(
//                    painter = painterResource(id = R.drawable.profile),
//                    contentDescription = "Account Image",
//                    modifier = Modifier
//                        .width(100.dp)
//                        .height(100.dp)
//                        .clickable {}
//                )
//
//            }
//
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
//                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
//                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
//                    .constrainAs(profile) {
//                        top.linkTo(topImg.bottom)
//                        start.linkTo(parent.start)
//                        end.linkTo(parent.end)
//                    }
//            ) {
//
//                Column(
//                    modifier = Modifier
//                        .padding(start = 8.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
//                        .height(90.dp)
//                        .width(90.dp)
//                        .background(
//                            color = Color(
//                                android.graphics.Color.parseColor(
//                                    "#ffe0c8"
//                                )
//                            ), shape = RoundedCornerShape(20.dp)
//                        ),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.notification),
//                        contentDescription = null,
//                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
//                    )
//
//                    Text(
//                        text = "Notification",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        fontStyle = FontStyle.Italic,
//                        color = Color(android.graphics.Color.parseColor("#c77710"))
//                    )
//
//                }
//
//                Column(
//                    modifier = Modifier
//                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
//                        .height(90.dp)
//                        .width(90.dp)
//                        .background(
//                            color = Color(
//                                android.graphics.Color.parseColor(
//                                    "#ffe0c8"
//                                )
//                            ), shape = RoundedCornerShape(20.dp)
//                        ),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.video_call),
//                        contentDescription = null,
//                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
//                    )
//
//                    Text(
//                        text = "Video Call",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        fontStyle = FontStyle.Italic,
//                        color = Color(android.graphics.Color.parseColor("#c77710"))
//                    )
//
//                }
//
//
//                Column(
//                    modifier = Modifier
//                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
//                        .height(90.dp)
//                        .width(90.dp)
//                        .background(
//                            color = Color(
//                                android.graphics.Color.parseColor(
//                                    "#ffe0c8"
//                                )
//                            ), shape = RoundedCornerShape(20.dp)
//                        ),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.voice_call),
//                        contentDescription = null,
//                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
//                    )
//
//                    Text(
//                        text = "Voice Call",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        fontStyle = FontStyle.Italic,
//                        color = Color(android.graphics.Color.parseColor("#c77710"))
//                    )
//
//                }
//
//            }
//        }
//
//
//
//
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
//
//        ) {
//            Column(
//                modifier = Modifier.weight(0.25f).clickable {
//                    Toast.makeText(context,"Clicked on OrderPlaced",Toast.LENGTH_SHORT).show()
//                    navHostController.navigate(NavScreens.PlaceOrder)
//
//                },
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_1),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Place Order",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_2),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Maps",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_3),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Chat",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_4),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Report",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//        }
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
//
//        ) {
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_5),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Calender",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_6),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Tips",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_7),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(16.dp)
//                )
//
//                Text(
//                    text = "Settings",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//            Column(
//                modifier = Modifier.weight(0.25f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_8),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(top = 8.dp, bottom = 4.dp)
//                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//                        .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 32.dp)
//                )
//
//                Text(
//                    text = "More",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp),
//                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
//                )
//            }
//
//        }
//
//    }


