package com.pandaapps.medicalstoremangementsystem.Screens.LogIn

import android.os.Build
import androidx.annotation.RawRes
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.core.ExperimentalAssetLoader
import app.rive.runtime.kotlin.core.Fit
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes
import com.pandaapps.medicalstoremangementsystem.R
import com.pandaapps.medicalstoremangementsystem.Screens.Components.HeaderText
import com.pandaapps.medicalstoremangementsystem.Screens.Components.TextField
import com.pandaapps.medicalstoremangementsystem.Screens.Components.TextFieldPassword
import com.pandaapps.medicalstoremangementsystem.Screens.DialogBoxWithProgressIndicator
import com.pandaapps.medicalstoremangementsystem.States.State
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp


@OptIn(ExperimentalAssetLoader::class)
@Composable

fun LogIn(
    navHostController: NavHostController,
    viewModelApp: ViewModelApp,
    userViewModel: UserViewModel
) {

    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var passwordError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    val isChecking = remember {
        mutableStateOf(false)
    }

    val trigFailed = remember {
        mutableStateOf(false)
    }

    val trigSuccess = remember {
        mutableStateOf(false)
    }

    var isChecked by remember { mutableStateOf(false) }

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

    when (viewModelApp.state.value) {

        State.Default.stateType -> {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HeaderText(
                    text = "LogIn",
                    fontFamily = customFontFamily,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(spacing))

                ComposableRiveAnimationView(
                    animation = R.raw.logincharacter,
                    modifier = Modifier
                        .size(300.dp)
                        .fillMaxWidth()
                ) {
                    it.setBooleanState(
                        "Login Machine",
                        "isHandsUp", passwordVisibility.value
                    )

                    it.setBooleanState("Login Machine", "isChecking", isChecking.value)

                    if (trigFailed.value) {
                        it.fireState("Login Machine", "trigFail")
                    }

                    if (trigSuccess.value) {
                        it.fireState("Login Machine", "trigSuccess")
                    }

                }

//                Image(
//                    painterResource(id = R.drawable.assistance),
//                    contentDescription = "Logo Image",
//                    modifier = Modifier.size(150.dp)
//                )


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
                    onValueChange = {
                        email = it
                        isChecking.value = true
                    },
                    labelText = "Email",
                    leadingIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    error = emailError
                )

                Spacer(modifier = Modifier.height(spacing + 2.dp))

                TextFieldPassword(
                    value = password,
                    onValueChange = {
                        password = it
                        isChecking.value = true
                    },
                    labelText = "Password",
                    leadingIcon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    error = passwordError,
                    passwordVisibility = passwordVisibility.value,
                    onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    },
                    Icon = if (passwordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff
                )

                Spacer(modifier = Modifier.height(spacing))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = {
                            isChecked = it
                            userViewModel.saveUserCredentials(email, password)
                        }
                    )
                    Text(
                        text = if (isChecked) "Remembered" else "Remember Me",
                        modifier = Modifier.padding(top = 10.dp, start = 4.dp)
                    )

                }

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

                        if (!hasError) {
                            viewModelApp.getId(email, password)
                            viewModelApp.logInUser(email = email, password = password)
                            trigSuccess.value = true

                        } else {
                            trigFailed.value = true
                        }


                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF011936)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("LogIn", color = Color.White, fontSize = 17.sp)
                }

                Spacer(modifier = Modifier.height(spacing + 6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navHostController.navigate(Routes.SignUpHolder)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Don't have an account?")

                    Text(text = " Sign Up")
                }

            }
        }

        State.LOADING.stateType -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogBoxWithProgressIndicator(text = "Loging In Account ...")
            }
        }

        State.SUCESS.stateType -> {
            navHostController.navigate(Routes.HomeHolder)
        }

        State.FAILED.stateType -> {
            viewModelApp.failedOrSuccessSetToDefault()
        }


    }


}

@OptIn(ExperimentalAssetLoader::class)
@Composable
fun ComposableRiveAnimationView(
    modifier: Modifier = Modifier,
    @RawRes animation: Int,
    stateMachineName: String? = null,
    alignment: app.rive.runtime.kotlin.core.Alignment = app.rive.runtime.kotlin.core.Alignment.CENTER,
    fit: Fit = Fit.CONTAIN,
    onInit: (RiveAnimationView) -> Unit = {}
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            RiveAnimationView(context).also {
                it.setRiveResource(
                    resId = animation,
                    stateMachineName = stateMachineName,
                    alignment = alignment,
                    fit = fit,

                    )
            }
        },
        update = { view -> onInit(view) }
    )
}



