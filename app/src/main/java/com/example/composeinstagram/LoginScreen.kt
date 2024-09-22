package com.example.composeinstagram

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close component",
        modifier = modifier.clickable {
            activity.finish()
        })
}

@Composable
fun Body(modifier: Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(false) }

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
        ) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordField(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            password
        ) { password = it }
        Spacer(modifier = Modifier.size((8).dp))
        ForgotPassword(
            Modifier
                .align(Alignment.End)
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
    TextField(
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
        )
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot Password?",
        fontSize = 12.sp,
        fontStyle = FontStyle.Italic,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun LoginButton(isLoginEnable: Boolean, modifier: Modifier) {
    Button(onClick = {}, enabled = isLoginEnable, modifier = modifier.fillMaxWidth()) {
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
            painterResource(id = R.drawable.logos__facebook),
            "Facebook",
            Modifier
                .size(20.dp)

        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            "Login with Facebook",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(horizontal = 8.dp),

        )
    }
}