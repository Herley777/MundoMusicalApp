package com.example.mundomusical

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LaranjaMundo = Color(0xFFFF6B00)
private val LaranjaClaro = Color(0xFFFF9A3D)
private val PretoMundo = Color(0xFF121212)
private val CardMundo = Color(0xFF1E1E1E)
private val BrancoMundo = Color(0xFFFFFFFF)
private val CinzaTexto = Color(0xFFD0D0D0)

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: () -> Unit,
    onGoToSignup: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PretoMundo)
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
                    .size(86.dp)
                    .background(
                        color = LaranjaMundo,
                        shape = RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = "Música",
                    tint = PretoMundo,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Mundo Musical",
                color = BrancoMundo,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Instrumentos Musicais do Mundo",
                color = CinzaTexto,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // CARD DE LOGIN
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardMundo
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    LaranjaMundo.copy(alpha = 0.35f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "Entrar",
                        color = BrancoMundo,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Acesse seu mundo musical.",
                        color = CinzaTexto,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(22.dp))

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
                                color = CinzaTexto
                            )
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            color = BrancoMundo
                        ),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = LaranjaMundo,
                            unfocusedBorderColor = Color(0xFF555555),
                            focusedLabelColor = LaranjaMundo,
                            unfocusedLabelColor = CinzaTexto,
                            cursorColor = LaranjaMundo,
                            focusedTextColor = BrancoMundo,
                            unfocusedTextColor = BrancoMundo
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

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
                                color = CinzaTexto
                            )
                        },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            color = BrancoMundo
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = LaranjaMundo,
                            unfocusedBorderColor = Color(0xFF555555),
                            focusedLabelColor = LaranjaMundo,
                            unfocusedLabelColor = CinzaTexto,
                            cursorColor = LaranjaMundo,
                            focusedTextColor = BrancoMundo,
                            unfocusedTextColor = BrancoMundo
                        )
                    )

                    // ERRO
                    state.error?.let {
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = it,
                            color = Color(0xFFFF6B6B),
                            fontSize = 13.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    // BOTÃO ENTRAR
                    Button(
                        onClick = {
                            viewModel.login(
                                email,
                                password,
                                onLoginSuccess
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        enabled = !state.loading,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LaranjaMundo,
                            contentColor = PretoMundo,
                            disabledContainerColor = LaranjaMundo.copy(alpha = 0.5f),
                            disabledContentColor = PretoMundo
                        )
                    ) {
                        if (state.loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(22.dp),
                                color = PretoMundo,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = "ENTRAR",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // CADASTRO
                    TextButton(
                        onClick = onGoToSignup,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ainda não tenho conta",
                            color = LaranjaClaro,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}