package com.pandaapps.medicalstoremangementsystem.Screens.BottomBar

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel

@Composable
fun Cart(userViewModel: UserViewModel) {


    val orders by userViewModel.orders.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        val vendorId = userViewModel.userId.value
        if (vendorId != 0) { // Ensure vendorId is valid
            userViewModel.fetchVendorOrders(vendorId)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Text(
            text = "Orders:",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold
        )

        LazyColumn {
            items(orders) { order ->

                Card(
                    Modifier.fillMaxWidth().padding(top = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {

                    Column(modifier = Modifier.padding(8.dp)) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Product Id: ${order.productId}",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )


                            Text(
                                text = "Order Date: ${order.dateOfOrder}",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Text(
                                text = "My Vendor Id: ${order.vendorId}",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = "Product Quantity: ${order.productQuantity ?: 0} ",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Order Id: ${order.orderId ?: 0} ",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = "Order Status: ${if (order.isApproved == 0) "Pending" else "Approved"} ",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }

                    }

                }

                Log.d(
                    "Orders",
                    "Cart:${order.orderId} ${order.productId} ${order.productQuantity} ${order.vendorId} ${order.isApproved} ${order.dateOfOrder} "
                )
            }
        }

    }


}