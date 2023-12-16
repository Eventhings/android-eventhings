package com.eventhngs.feature_auth.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eventhngs.feature_auth.R
import com.eventhngs.ui.theme.EventhngsTheme
import com.eventhngs.ui.theme.Purple1
import com.eventhngs.ui.theme.black1
import com.eventhngs.ui.theme.blue1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToMainScreen: () -> Unit = {},
    navigateToRegisterScreen: () -> Unit = {},
    navigateToForgotPasswordScreen: () -> Unit = {}
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isValid by rememberSaveable { mutableStateOf(false) }

    val passwordVisible = remember{ mutableStateOf(false) }
    val context = LocalContext.current

    val forgotPassword = stringResource(R.string.forgot_password) + stringResource(R.string.space)
    val registerText = stringResource(R.string.register)
    val registerString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = black1)){
            pushStringAnnotation(tag = forgotPassword, annotation = forgotPassword)
            append(forgotPassword)
        }
        withStyle(style = SpanStyle(color = blue1, fontWeight = FontWeight.SemiBold)){
            pushStringAnnotation(tag = registerText, annotation = registerText)
            append(registerText)
        }
    }

    Column(
        modifier = modifier.padding(horizontal = 35.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
            color = blue1
        )
        Text(text = stringResource(R.string.desc_login),)


        OutlinedTextField(
            modifier = Modifier
                .padding(top = 28.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            value = email,
            onValueChange ={newEmail ->
                email = newEmail
                isValid = isEmailValid(newEmail) && isPasswordValid(password)
            },
            label = { Text(stringResource(R.string.email)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )


        OutlinedTextField(
            modifier = Modifier
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            value = password,
            onValueChange ={ newPassword ->
                password = newPassword
                isValid = isEmailValid(email) && isPasswordValid(newPassword)
            },
            label = { Text(stringResource(R.string.password)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val iconImage = if(passwordVisible.value){
                    Icons.Filled.Visibility
                }else{
                    Icons.Filled.VisibilityOff
                }

                var description = if (passwordVisible.value){
                    stringResource(R.string.hide_password)
                } else{
                    stringResource(R.string.show_password)
                }
                IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                    Image(imageVector = iconImage, contentDescription = description)
                }
            },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )

        Button(
            modifier = Modifier
                .padding(top = 30.dp)
                .height(50.dp)
                .fillMaxWidth(),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple1
            ),
            onClick = {
                if (email.isEmpty()){
                    Toast.makeText(context, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }else if (password.isEmpty()){
                    Toast.makeText(context, "Pleae Enter Password", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Validation Succesfully Completed", Toast.LENGTH_SHORT).show()
                    navigateToMainScreen()
                }
            }
        ) {
            Box (
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(stringResource(R.string.login))
            }
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)){
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = blue1, fontWeight = FontWeight.SemiBold)){
                        append("Register")
                    }
                },
                style = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center
                ),
                onClick = {
                    navigateToRegisterScreen()
                }
            )
            ClickableText(
                modifier = Modifier.padding(start = 130.dp),
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = black1)){
                        append("Forgot password?")
                    }
                },
                style = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.End
                ),
                onClick = {
                    navigateToForgotPasswordScreen()
                }
            )

        }

    }
}

fun isEmailValid(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}

fun isPasswordValid(password: String): Boolean {
    return password.length >= 8
}

@Preview
@Composable
fun LoginScreenPreview() {
    EventhngsTheme {
        LoginScreen()
    }

}


/*
BaseButton(
            text = "Ke Halaman Forgot Password",
            onClick = navigateToForgotPasswordScreen
        )
        BaseButton(
            text = "Ke Halaman Home",
            onClick = navigateToHomeScreen
        )
 */
