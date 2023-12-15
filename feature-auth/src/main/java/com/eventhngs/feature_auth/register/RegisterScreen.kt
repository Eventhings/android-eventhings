package com.eventhngs.feature_auth.register

import android.transition.Visibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eventhngs.feature_auth.R
import androidx.navigation.NavHostController
import com.eventhngs.ui.theme.Purple1
import com.eventhngs.ui.theme.grey1
import com.eventhngs.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val passwordVisible = remember{ mutableStateOf(false) }


    Column(
        modifier
            .padding(top = 100.dp, start = 35.dp, end = 49.dp, bottom = 100.dp ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier
                .height(210.dp)
                .width(210.dp),
            painter = painterResource(R.drawable.eventhings_logo),
            contentDescription = null
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 28.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            value = email,
            onValueChange ={newEmail ->
                email = newEmail
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
            onValueChange ={newPassword ->
                password = newPassword
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
                    Icon(imageVector = iconImage, contentDescription = description)
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
                navHostController.navigate("login")
            }
        ) {
            Box (
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(stringResource(R.string.continuee))

            }

        }

        Row (
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = grey1,
                thickness = 1.dp
            )
            Text(text = "or", fontSize = 14.sp)

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = grey1,
                thickness = 1.dp
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 25.dp)
                .height(50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.DarkGray,
                containerColor = white
            ),
            border = BorderStroke(1.dp, Color.LightGray),
            onClick = { /*TODO*/ }
        ) {
            Box (contentAlignment = Alignment.Center){

                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(R.drawable.ic_google),
                        contentDescription = null,
                    )
                    Text(
                        stringResource(R.string.sign_with_google),
                        modifier = Modifier.padding(start = 10.dp),
                    )
                }


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {

}