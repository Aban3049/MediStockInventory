package com.pandaapps.medicalstoremangementsystem.Screens.OrderPlace


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandaapps.medicalstoremangementsystem.Api.ProductResponse
import com.pandaapps.medicalstoremangementsystem.R
import com.pandaapps.medicalstoremangementsystem.Screens.DialogBoxWithProgressIndicator
import com.pandaapps.medicalstoremangementsystem.Screens.DialogWithImage
import com.pandaapps.medicalstoremangementsystem.States.State
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp


@Composable
fun PlaceOrder(
    viewModelApp: ViewModelApp,
    userViewModel: UserViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val allProducts by viewModelApp.allProducts.collectAsState(initial = emptyList())

    val expanded = rememberSaveable { mutableStateOf(false) }
    var selectedProduct by rememberSaveable {
        mutableStateOf<ProductResponse.ProductResponseItem?>(
            null
        )
    }

    val context = LocalContext.current

    var showReceipt by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }


    var productQuantity by rememberSaveable { mutableIntStateOf(0) }

    val userId by userViewModel.userId.collectAsState()

    val productPrice = selectedProduct?.price ?: 0.0


    var TotalPrice by rememberSaveable {
        mutableDoubleStateOf(0.0)
    }

    when (viewModelApp.state.value) {

        State.Default.stateType -> {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    colors = CardDefaults.cardColors(Color(0xFF171717)),
                    elevation = CardDefaults.elevatedCardElevation(10.dp), shape = RoundedCornerShape(8.dp),
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
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    OutlinedTextField(
                        value = selectedProduct?.name ?: "---Select Product---",
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

                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        allProducts.forEach { product ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = product.name ?: "Unknown",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                },
                                onClick = {
                                    selectedProduct = product
                                    expanded.value = false
                                }
                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    elevation = CardDefaults.elevatedCardElevation(8.dp)
                ) {
                    OutlinedTextField(
                        value = productQuantity.toString(),
                        onValueChange = {
                            productQuantity = it.toIntOrNull() ?: 0
                        },
                        textStyle = MaterialTheme.typography.titleMedium,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.AddCircle,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    productQuantity++
                                }
                            )
                        }
                    )
                }



                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    listOf(50, 100, 150, 200).forEach { quantity ->
                        Card(
                            modifier = Modifier
                                .clip(CircleShape)
                                .weight(1f), elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Text(
                                text = quantity.toString(),
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clickable {
                                        productQuantity = quantity
                                    },
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.Black
                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))


                Button(
                    onClick = {
                        if (selectedProduct != null && productQuantity > 0) {
                            showReceipt = true
                            showDialog = false
                        } else {
                            showReceipt = false
                            showDialog = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "View Receipt")
                }

                if (showReceipt) {
                    Column(modifier = Modifier.fillMaxWidth()) {

                        TotalPrice = selectedProduct!!.price!! * productQuantity

                        OrderReceipt(
                            selectedProduct = selectedProduct,
                            productQuantity = productQuantity,
                            totalPrice = TotalPrice
                        )
                    }
                }

                if (showDialog) {
                    DialogWithImage(
                        onDismissRequest = {
                            showDialog = false
                        },
                        onConfirmation = {
                            showDialog = false
                        },
                        painter = painterResource(id = R.drawable.angry),
                        imageDescription = "angry",
                        text = "Please select a product and quantity",

                        )
                }

                Button(
                    onClick = {
                        if (selectedProduct != null && productQuantity > 0) {
                            showReceipt = true
                            showDialog = false
                            viewModelApp.placeOrder(
                                productId = selectedProduct!!.productId!!,
                                productQuantity = productQuantity,
                                vendorId = userId
                            )
                        } else {
                            showReceipt = false
                            showDialog = true
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "Place Order")
                }


            }
        }

        State.LOADING.stateType -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogBoxWithProgressIndicator(text = "Ordering Product ...")
            }
        }

        State.SUCESS.stateType -> {
            Toast.makeText(context, "Order Placed Successfully", Toast.LENGTH_SHORT).show()
            viewModelApp.failedOrSuccessSetToDefault()
        }
    }




}


@Composable
fun OrderReceipt(
    selectedProduct: ProductResponse.ProductResponseItem?,
    productQuantity: Int?,
    totalPrice: Double
) {

    Card(
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
            Text(text = "${selectedProduct!!.productId ?: 0}")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Stock Quantity Available:")
            Text(text = "${selectedProduct!!.stock ?: 0}")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Order Quantity:")
            Text(text = "${productQuantity ?: 0}")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Product Price:")
            Text(text = "${selectedProduct!!.price ?: 0}")
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
            Text(text = "Total Price")
            Text(text = "$totalPrice")
        }


    }
}



