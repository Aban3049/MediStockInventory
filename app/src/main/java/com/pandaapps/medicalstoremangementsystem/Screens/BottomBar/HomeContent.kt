package com.pandaapps.medicalstoremangementsystem.Screens.BottomBar

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes
import com.pandaapps.medicalstoremangementsystem.R

@Composable
fun HomeContent(navHostController: NavHostController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                color = Color(android.graphics.Color.parseColor("#f8eeec"))
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ConstraintLayout {

            val (topImg, profile) = createRefs()

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(245.dp)
                .constrainAs(topImg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#EA6D35")),
                            Color(android.graphics.Color.parseColor("#3B608C"))
                        )
                    ), shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)

                )


            )


            Row(
                modifier = Modifier
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Hello", color = Color.White, fontSize = 18.sp)

                    Text(
                        text = "Muhammad Aban",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Account Image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {}
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

                Column(
                    modifier = Modifier
                        .padding(start = 8.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(
                                android.graphics.Color.parseColor(
                                    "#ffe0c8"
                                )
                            ), shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )

                    Text(
                        text = "Notification",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(android.graphics.Color.parseColor("#c77710"))
                    )

                }

                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(
                                android.graphics.Color.parseColor(
                                    "#ffe0c8"
                                )
                            ), shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.video_call),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )

                    Text(
                        text = "Video Call",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(android.graphics.Color.parseColor("#c77710"))
                    )

                }


                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(
                                android.graphics.Color.parseColor(
                                    "#ffe0c8"
                                )
                            ), shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.voice_call),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )

                    Text(
                        text = "Voice Call",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color(android.graphics.Color.parseColor("#c77710"))
                    )

                }

            }
        }





        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)

        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f)
                    .clickable {
                        Toast
                            .makeText(context, "Clicked on OrderPlaced", Toast.LENGTH_SHORT)
                            .show()
                        navHostController.navigate(Routes.PlaceOrder)

                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Place Order",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Maps",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_3),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Chat",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_4),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Report",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)

        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_5),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Calender",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_6),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Tips",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_7),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = androidx.compose.ui.graphics.Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )

                Text(
                    text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_8),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 32.dp)
                )

                Text(
                    text = "More",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#2e3d6d"))
                )
            }

        }

    }


}