package com.pandaapps.medicalstoremangementsystem.Screens.BottomBar

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person2
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile() {

    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .height(170.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomEnd = 150.dp, bottomStart = 150.dp))
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding()
                .offset(y = (-70).dp)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp),
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
            
            Spacer(modifier = Modifier.height(2.dp).background(Color(0xFFA1A1A1)))

        }


    }


}