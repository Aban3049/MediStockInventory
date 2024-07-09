package com.pandaapps.medicalstoremangementsystem.Screens.OrderPlace


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandaapps.medicalstoremangementsystem.Api.ProductResponse
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen


@Composable
fun PlaceOrder(viewModel: ViewModelSignupScreen) {

    val allProducts =
        viewModel.allProducts.collectAsState(initial = emptyList<ProductResponse.ProductResponseItem>())


    val expanded = rememberSaveable { mutableStateOf(false) }
    val selectedProduct =
        rememberSaveable { mutableStateOf<ProductResponse.ProductResponseItem?>(null) }
    val productQuantity = rememberSaveable { mutableStateOf(0) }

    val productPrice = selectedProduct.value?.price ?: 0.0

    val totalPrice by remember {
        derivedStateOf { productPrice * productQuantity.value }
    }

    Column(modifier = Modifier.padding(10.dp)) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            backgroundColor = Color(0xFF171717),
            elevation = 10.dp, shape = RoundedCornerShape(8.dp),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Let’s order for you! \uD83D\uDED2",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total Orders:",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "0",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pending Orders:",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "0",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Level:",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "0",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            elevation = 8.dp
        ) {
            OutlinedTextField(
                value = selectedProduct.value?.name ?: "---Select Product---",
                textStyle = MaterialTheme.typography.titleMedium,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded.value = true },
                readOnly = true,
                shape = RoundedCornerShape(14.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            expanded.value = true
                        }
                    )
                }
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            allProducts.value.forEach { product ->
                DropdownMenuItem(
                    text = {
                        Text(text = product.name!!, style = MaterialTheme.typography.titleMedium)
                    },
                    onClick = {
                        selectedProduct.value = product
                        expanded.value = false
                    }
                )
            }
        }



        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            elevation = 8.dp
        ) {
            OutlinedTextField(
                value = "Product Quantity: ${productQuantity.value}",
                onValueChange = { productQuantity.value = it.toIntOrNull() ?: 0 },
                textStyle = MaterialTheme.typography.titleMedium,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            productQuantity.value++
                        }
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf(50, 100, 150, 200).forEach { quantity ->
                Card(
                    modifier = Modifier
                        .clip(CircleShape)
                        .weight(1f), elevation = 8.dp
                ) {
                    Text(
                        text = quantity.toString(),
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                productQuantity.value = quantity
                            },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.Black
                    )
                }
            }
        }

        androidx.compose.material3.Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Product id:")
                Text(text = "1")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Stock Quantity Available:")
                Text(text = "1")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order Quantity:")
                Text(text = "100")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total Price:")
                Text(text = "100$")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "GST:")
                Text(text = "10%")
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Black)
                    .padding(top = 4.dp, bottom = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$totalPrice",)
                Text(text = "110$")
            }


        }

        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {

                }
        ) {
            Text(text = "Place Order")
        }


    }
}


@Preview(showSystemUi = true)
@Composable

fun OrderPreview() {
    PlaceOrder(viewModel = ViewModelSignupScreen())
}



