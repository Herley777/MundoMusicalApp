package com.example.mundomusical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LaranjaCadastro = Color(0xFFFF6B00)
private val LaranjaClaroCadastro = Color(0xFFFF9A3D)
private val PretoCadastro = Color(0xFF121212)
private val CardCadastro = Color(0xFF1E1E1E)
private val BrancoCadastro = Color(0xFFFFFFFF)
private val CinzaCadastro = Color(0xFFD0D0D0)

@Composable
fun SignupScreen(
    viewModel: AuthViewModel,
    onSignupSuccess: () -> Unit,
    onBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PretoCadastro)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // LOGO
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        LaranjaCadastro,
                        RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "♫",
                    color = PretoCadastro,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Criar conta",
                color = BrancoCadastro,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Faça parte do Mundo Musical.",
                color = CinzaCadastro,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(26.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardCadastro
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    LaranjaCadastro.copy(alpha = 0.35f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "Novo usuário",
                        color = BrancoCadastro,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // E-MAIL
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            viewModel.clearError()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = "E-mail",
                                color = CinzaCadastro
                            )
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            color = BrancoCadastro
                        ),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = LaranjaCadastro,
                            unfocusedBorderColor = Color(0xFF555555),
                            focusedLabelColor = LaranjaCadastro,
                            unfocusedLabelColor = CinzaCadastro,
                            cursorColor = LaranjaCadastro,
                            focusedTextColor = BrancoCadastro,
                            unfocusedTextColor = BrancoCadastro
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // SENHA
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            viewModel.clearError()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = "Senha",
                                color = CinzaCadastro
                            )
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            color = BrancoCadastro
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = LaranjaCadastro,
                            unfocusedBorderColor = Color(0xFF555555),
                            focusedLabelColor = LaranjaCadastro,
                            unfocusedLabelColor = CinzaCadastro,
                            cursorColor = LaranjaCadastro,
                            focusedTextColor = BrancoCadastro,
                            unfocusedTextColor = BrancoCadastro
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // CONFIRMAR SENHA
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {
                            confirmPassword = it
                            viewModel.clearError()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = "Confirmar senha",
                                color = CinzaCadastro
                            )
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            color = BrancoCadastro
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = LaranjaCadastro,
                            unfocusedBorderColor = Color(0xFF555555),
                            focusedLabelColor = LaranjaCadastro,
                            unfocusedLabelColor = CinzaCadastro,
                            cursorColor = LaranjaCadastro,
                            focusedTextColor = BrancoCadastro,
                            unfocusedTextColor = BrancoCadastro
                        )
                    )

                    // SENHAS DIFERENTES
                    if (
                        confirmPassword.isNotEmpty() &&
                        password != confirmPassword
                    ) {
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "As senhas não coincidem.",
                            color = Color(0xFFFF6B6B),
                            fontSize = 13.sp
                        )
                    }

                    // ERRO DO FIREBASE
                    state.error?.let {
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = it,
                            color = Color(0xFFFF6B6B),
                            fontSize = 13.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // BOTÃO CADASTRAR
                    Button(
                        onClick = {
                            if (password == confirmPassword) {
                                viewModel.signup(
                                    email,
                                    password,
                                    onSignupSuccess
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        enabled =
                            !state.loading &&
                                    password.isNotEmpty() &&
                                    password == confirmPassword,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LaranjaCadastro,
                            contentColor = PretoCadastro,
                            disabledContainerColor =
                                LaranjaCadastro.copy(alpha = 0.35f),
                            disabledContentColor = PretoCadastro
                        )
                    ) {
                        if (state.loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(22.dp),
                                color = PretoCadastro,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = "CRIAR CONTA",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // VOLTAR
                    TextButton(
                        onClick = onBack,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Voltar para o login",
                            color = LaranjaClaroCadastro,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}