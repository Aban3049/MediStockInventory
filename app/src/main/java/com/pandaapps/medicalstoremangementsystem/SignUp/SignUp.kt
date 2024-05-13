package com.pandaapps.medicalstoremangementsystem.SignUp

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.pandaapps.medicalstoremangementsystem.ui.theme.MedicalStoreMangementSystemTheme


@Composable
fun SignUp() {

    val (name, setName) = remember {
        mutableStateOf("")
    }

    val (password, setPassword) = remember {
        mutableStateOf("")
    }

    val (email, setEmail) = remember {
        mutableStateOf("")
    }

    val (phoneNo, setPhoneNumber) = remember {
        mutableStateOf("")
    }

    val (address, setAddress) = remember {
        mutableStateOf("")
    }

    val (pinCode, setPinCode) = remember {
        mutableStateOf("")
    }

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

        HeaderText(text = "Sign Up", modifier = Modifier, textAlign = TextAlign.Start, fontFamily = customFontFamily)



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
            onValueChange = setName,
            labelText = "Name",
            leadingIcon = Icons.Default.Person
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Email,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = email,
            onValueChange = setEmail,
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = phoneNo,
            onValueChange = setPhoneNumber,
            labelText = "Phone No",
            leadingIcon = Icons.Default.Phone,
            keyboardType = KeyboardType.Phone
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = pinCode,
            onValueChange = setPinCode,
            labelText = "Pin Code",
            leadingIcon = Icons.Default.Star
        )

        Spacer(modifier = Modifier.height(spacing))

        TextField(
            value = address,
            onValueChange = setAddress,
            labelText = "Address",
            leadingIcon = Icons.Default.LocationOn
        )

        Spacer(modifier = Modifier.height(spacing + 7.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF011936)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Sign Up", fontSize = 17.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(spacing))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already have Account?")
            Text("LogIn")

        }


    }

}


@Preview(showSystemUi = true)
@Composable

fun PreviewSignUp() {

    MedicalStoreMangementSystemTheme {
        SignUp()
    }


}