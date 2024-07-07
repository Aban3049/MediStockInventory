package com.pandaapps.medicalstoremangementsystem.Screens.OrderPlace


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pandaapps.medicalstoremangementsystem.Api.ProductResponse
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen


@Composable
fun PlaceOrder(viewModel: ViewModelSignupScreen) {

    val allProducts = viewModel.allProducts.value ?: emptyList()

    val expanded = remember { mutableStateOf(false) }
    val selectedProduct = remember { mutableStateOf<ProductResponse.ProductResponseItem?>(null) }

    Column {
        OutlinedTextField(
            value = selectedProduct.value?.name ?: "---Select Product---",
            textStyle = MaterialTheme.typography.titleMedium,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded.value = true },
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        expanded.value = true
                    }
                )
            },

        )

        if (expanded.value) {
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                allProducts.forEach { product ->
                    DropdownMenuItem(text = {
                        Text(text = product.name!!, style = MaterialTheme.typography.titleMedium)
                    }, onClick = {
                        selectedProduct.value = product
                        expanded.value = false
                    })
                }
            }

        }








        LazyColumn() {

            items(allProducts.size) { product ->


            }


//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp)
//            ) {
//
//
//
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//
//                    Text(
//                        text = allProducts[product].name!!,
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//
//                    Text(
//                        text = allProducts[product].category!!,
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//
//                    Text(
//                        text = "${allProducts[product].price}",
//                        style = MaterialTheme.typography.labelSmall
//                    )
//                    Text(
//                        text = "${allProducts[product].stock}",
//                        style = MaterialTheme.typography.labelSmall
//                    )
//
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//
//                    Text(
//                        text = "${allProducts[product].isActive}",
//                        style = MaterialTheme.typography.labelSmall
//                    )
//                    Text(
//                        text = "${allProducts[product].productId}",
//                        style = MaterialTheme.typography.labelSmall
//                    )
//
//                }
//
//            }

        }


    }
}




