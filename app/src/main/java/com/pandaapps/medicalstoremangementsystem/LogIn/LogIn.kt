package com.pandaapps.medicalstoremangementsystem.LogIn

import android.os.Build
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandaapps.medicalstoremangementsystem.Components.HeaderText
import com.pandaapps.medicalstoremangementsystem.Components.TextField
import com.pandaapps.medicalstoremangementsystem.R

@Composable

fun LogIn() {

    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var passwordError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }

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
            .padding(contentPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HeaderText(text = "LogIn", fontFamily = customFontFamily, textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(spacing))

        Image(
            painterResource(id = R.drawable.assistance),
            contentDescription = "Logo Image",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(8.dp + 6.dp))

        Text(
            "Welcome To MediStock Manager ",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold
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

        Spacer(modifier = Modifier.height(spacing + 2.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            error = passwordError
        )

        Spacer(modifier = Modifier.height(spacing + 9.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {

                var hasError = false

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

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF011936)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("LogIn", color = Color.White, fontSize = 17.sp)
        }

        Spacer(modifier = Modifier.height(spacing + 6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have an account?")

            Text(text = " Sign Up")
        }

    }

}

@Preview(showSystemUi = true)
@Composable

fun showLogInScreen() {
    LogIn()
}