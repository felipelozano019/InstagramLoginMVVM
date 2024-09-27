package com.example.composeinstagram.login.presentation

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinstagram.R


@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "close component",
        modifier = modifier.clickable {
            activity.finish()
        })
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {

    val email: String by loginViewModel.email.observeAsState("")
    val password: String by loginViewModel.password.observeAsState("")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial =false)


    Column(modifier = modifier) {
        ImageLogo(
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 300.dp, height = 100.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        EmailField(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), email
        ) { loginViewModel.onLoginChange(it, password) }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordField(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(), password
        ) { loginViewModel.onLoginChange(email,it) }
        Spacer(modifier = Modifier.size((8).dp))
        ForgotPassword(
            Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        RowSocial()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.iglogo),
        contentDescription = "ig logo",
        modifier = modifier
    )
}

@Composable
fun EmailField(modifier: Modifier, email: String, onEmailChange: (String) -> Unit) {
    TextField(
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        value = email,
        onValueChange = { onEmailChange(it) },
        modifier = modifier,
        label = { Text("Email") },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
        )
    )
}

@Composable
fun PasswordField(modifier: Modifier, password: String, onPasswordChange: (String) -> Unit) {

    var passwordVisibility by remember { mutableStateOf(false) }

    TextField(
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password,
        onValueChange = { onPasswordChange(it) },
        modifier = modifier,
        label = { Text("Password") },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
        ),
        trailingIcon = {
            val img = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = img, contentDescription = "password visibility")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )

}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun LoginButton(isLoginEnable: Boolean, modifier: Modifier) {
    Button(
        onClick = {},
        enabled = isLoginEnable,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9).copy(alpha = 0.5f),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text("Login")
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .background(Color.LightGray)
                .height(1.dp)
        )
        Text(
            "OR",
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.LightGray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .background(Color.LightGray)
                .height(1.dp)
        )
    }
}

@Composable
fun RowSocial() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.logos__facebook), "Facebook", Modifier.size(20.dp)

        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            "Login with Facebook",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp),

            )
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier.fillMaxWidth()) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .height(1.dp)
        )
        SignUp(modifier = Modifier.align(Alignment.CenterHorizontally))
    }

}

@Composable
fun SignUp(modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            "Don't have an account?",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            "Sign Up", fontSize = 14.sp, color = Color(0xFF4EA8E9), fontWeight = FontWeight.Bold
        )
    }
}
