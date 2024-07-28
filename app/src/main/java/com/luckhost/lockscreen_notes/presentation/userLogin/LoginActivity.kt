package com.luckhost.lockscreen_notes.presentation.userLogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.luckhost.lockscreen_notes.R
import com.luckhost.lockscreen_notes.presentation.userLogin.ui.theme.Lockscreen_notesTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {
    private val vm by viewModel<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lockscreen_notesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.main_bg)
                ) {
                    ScreenLayout()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenLayout() {
    var nicknameFieldState by remember {
        mutableStateOf("")
    }
    nicknameFieldState = stringResource(id = R.string.login_activity_nickname_text_field)

    var passwordFieldState by remember {
        mutableStateOf("")
    }
    passwordFieldState = stringResource(id = R.string.login_activity_password_text_field)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
            val (headerRef, nicknameInpRef,
                passInpRef, buttonsRowRef) = createRefs()
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(headerRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(nicknameInpRef.top, margin = 25.dp)
                    }
                    .fillMaxWidth(),
                text = stringResource(id = R.string.login_activity_main_text),
                style = TextStyle(
                    color = colorResource(id = R.color.main_title_text),
                    fontSize = 46.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                ),
            )

            OutlinedTextField(
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(nicknameInpRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(passInpRef.top, margin = 24.dp)
                    },
                value = nicknameFieldState,
                onValueChange = { nicknameFieldState = it },
                textStyle = TextStyle(
                    color = colorResource(id = R.color.grey_neutral),
                    fontSize = 16.sp
                ),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.main_bg),
                    unfocusedContainerColor = colorResource(id = R.color.main_bg),
                )
            )

            OutlinedTextField(
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(passInpRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                value = passwordFieldState,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { passwordFieldState = it },
                textStyle = TextStyle(
                    color = colorResource(id = R.color.grey_neutral),
                    fontSize = 16.sp
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(id = R.color.main_bg),
                    unfocusedContainerColor = colorResource(id = R.color.main_bg),
                )
            )

            Row(modifier = Modifier
                .constrainAs(buttonsRowRef) {
                    top.linkTo(passInpRef.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .wrapContentSize(),
                horizontalArrangement = Arrangement.Center

            ) {
                TextButton(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .wrapContentSize(),
                    onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.login_activity_sign_in_button),
                        color = colorResource(id = R.color.main_title_text),
                        style = TextStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
                Button(
                    modifier = Modifier
                        .wrapContentSize()
                        .width(160.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, colorResource(id = R.color.button_stroke)),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.grey_neutral),
                        contentColor = colorResource(id = R.color.light_grey),
                        disabledContainerColor = colorResource(id = R.color.grey_neutral),
                        disabledContentColor = colorResource(id = R.color.light_grey),
                    ),
                    onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.login_activity_next_button),
                        style = TextStyle(fontSize = 26.sp),
                        color = colorResource(id = R.color.heavy_metal),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}