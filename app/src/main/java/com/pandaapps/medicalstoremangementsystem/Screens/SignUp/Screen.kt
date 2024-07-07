package com.pandaapps.medicalstoremangementsystem.Screens.SignUp

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Screens.Components.HeaderText
import com.pandaapps.medicalstoremangementsystem.Screens.Components.TextField
import com.pandaapps.medicalstoremangementsystem.Navigation.NavScreens
import com.pandaapps.medicalstoremangementsystem.R
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen


@Composable
fun SignUpScreen(viewModel: ViewModelSignupScreen, navController: NavHostController) {


    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNo by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var pinCode by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var phoneNoError by remember { mutableStateOf<String?>(null) }
    var addressError by remember { mutableStateOf<String?>(null) }
    var pinCodeError by remember { mutableStateOf<String?>(null) }



    val customFontFamily = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        FontFamily(
            Font(R.font.poppinsblack, FontWeight.Normal),
            Font(R.font.poppinsbold, FontWeight.Bold),
            Font(R.font.poppinsextrabold, FontWeight.ExtraBold),
            Font(R.font.poppinsextrabolditalic, FontWeight.Bold),


            )
    } else {
        FontFamily.Default
    }


    val contentPadding = 16.dp
    val spacing = 8.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HeaderText(
            text = "Sign Up",
            modifier = Modifier,
            textAlign = TextAlign.Start,
            fontFamily = customFontFamily
        )



        Image(
            painter = painterResource(id = R.drawable.assistance), // Replace 'my_image' with your image file's name
            contentDescription = "Description for the image", // Provide a meaningful description
            modifier = Modifier.size(150.dp) // Set the size as needed
        )

        Spacer(modifier = Modifier.height(spacing + 6.dp))

        Text(
            text = "Welcome To MediStock Manager",

            fontFamily = FontFamily.Default,
            fontSize = 22.sp,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold


        )




        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = name,
            onValueChange = { name = it },
            labelText = "Name",
            leadingIcon = Icons.Default.Person,
            error = nameError

        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = password,
            onValueChange = { password = it },
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Email,
            visualTransformation = PasswordVisualTransformation(),
            error = passwordError
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = email,
            onValueChange = { email = it },
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            error = emailError
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = phoneNo,
            onValueChange = { phoneNo = it },
            labelText = "Phone No",
            leadingIcon = Icons.Default.Phone,
            keyboardType = KeyboardType.Phone,
            error = phoneNoError
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = pinCode,
            onValueChange = { pinCode = it },
            labelText = "Pin Code",
            leadingIcon = Icons.Default.Star,
            error = pinCodeError
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = address,
            onValueChange = { address = it },
            labelText = "Address",
            leadingIcon = Icons.Default.LocationOn,
            error = addressError
        )

        Spacer(modifier = Modifier.height(spacing + 7.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {

                var hasError = false

                if (name.isBlank()) {
                    nameError = "Name cannot be empty"
                    hasError = true
                } else {
                    nameError = null
                }

                if (password.isBlank()) {
                    passwordError = "Password cannot be empty"
                    hasError = true
                } else {
                    passwordError = null
                }

                if (email.isBlank()) {
                    emailError = "Email cannot be empty"
                    hasError = true
                } else {
                    emailError = null
                }

                if (phoneNo.isBlank()) {
                    phoneNoError = "Phone No cannot be empty"
                    hasError = true
                } else {
                    phoneNoError = null
                }

                if (pinCode.isBlank()) {
                    pinCodeError = "Pin Code cannot be empty"
                    hasError = true
                } else {
                    pinCodeError = null
                }

                if (address.isBlank()) {
                    addressError = "Address cannot be empty"
                    hasError = true
                } else {
                    addressError = null
                }

                if (!hasError) {
                    viewModel.createUser(
                        name = name,
                        password = password,
                        email = email,
                        phoneNo = phoneNo,
                        address = address,
                        pinCode = pinCode
                    )
                }


            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF011936)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Sign Up", fontSize = 17.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(spacing))

        Row(
            modifier = Modifier.fillMaxWidth().clickable {
                navController.navigate(NavScreens.LoginPageHolder)
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text("Already have Account?")
            Text("LogIn")

        }


    }

}