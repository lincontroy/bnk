package com.dev.chacha.auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToHome: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
    viewModel: LoginViewModel,
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = stringResource(R.string.welcome_back),
                showForwardArrow = true,
                showBackArrow = true
            )
        },
        bottomBar = {
            EquityButton(
                onClick = { onNavigateToHome() },
                text = stringResource(id = R.string.enter_password_to_sign_in),
                enable = true,
            )

        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = stringResource(R.string.hello_there),
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = stringResource(id = R.string.login_header_description),
                    maxLines = 2,
                    style = MaterialTheme.typography.titleSmall


                )
                AppTextField(
                    text = viewModel.usernameText.value,
                    onValueChange = {
                        viewModel.setUsernameText(it)
                    },
                    error = viewModel.usernameError.value,
                    hint = stringResource(id = R.string.email_hint),
                    title = stringResource(id = R.string.email_hint),

                    )

                AppTextField(
                    text = viewModel.passwordText.value,
                    onValueChange = {
                        viewModel.setPasswordText(it)
                    },
                    hint = stringResource(id = R.string.login_password_hint),
                    keyboardType = KeyboardType.Password,
                    error = viewModel.passwordError.value,
                    isPasswordVisible = viewModel.showPassword.value,
                    onPasswordToggleClick = {
                        viewModel.setShowPassword(it)
                    },
                    title = stringResource(id = R.string.login_password_title),
                )

                Text(
                    text = stringResource(id = R.string.forgot_password),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onForgotClick() },
                    style = MaterialTheme.typography.titleSmall
                )


            }

        }

    }
}

