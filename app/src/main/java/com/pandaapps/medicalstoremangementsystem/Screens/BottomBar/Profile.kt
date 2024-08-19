package com.pandaapps.medicalstoremangementsystem.Screens.BottomBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.Signpost
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, device = "spec:width=1220px,height=1660px,dpi=440")
@Composable


fun Profile() {

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Card(
                modifier = Modifier
                    .height(170.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(bottomEnd = 110.dp, bottomStart = 110.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF5e43b6),
                                Color(0xFF895ac2)
                            )
                        )
                    ),
                colors = CardDefaults.cardColors(Color.Transparent),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Muhammad Aban", color = Color.White, fontSize = 22.sp)
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-80).dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Spacer(
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .border(border = BorderStroke(1.dp, Color.Black), shape = CircleShape)
                            .clip(CircleShape)
                            .background(Color.White)

                    )

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(85.dp),
                        tint = Color(0xFF7d54be)
                    )

                }


            }


        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding()
                .offset(y = (-80).dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person2,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "Muhammad Aban",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "allabouttechnolgy@gmail.com",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.PhoneIphone,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "+92 154595060",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Business,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "Seller Level: 5",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "Shop no 4 streat no 8 i10/4 Islamabad ",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 20.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Signpost,
                    contentDescription = null,
                    Modifier
                        .size(34.dp)
                        .weight(.5f),
                    tint = Color(0xFF6956F0),
                )
                Text(
                    text = "5500",
                    color = Color(0xFFA1A1A1),
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            Spacer(modifier = Modifier
                .height(2.dp)
                .background(Color(0xFFF6F6F6))
                .fillMaxWidth())

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp), horizontalArrangement = Arrangement.Center) {

                Button(onClick = {

                }, modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF3832AA),
                                Color(0xFF744FBC),
                                Color(0xFFA76ACB)
                            )
                        )
                    )
                    .width(210.dp)
                    .height(52.dp), colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                    Text(text = "Edit Profile", fontSize = 16.sp)
                }


            }



        }


    }




}