package com.example.mundomusical

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: () -> Unit,
    onGoToSignup: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(28.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.MusicNote,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(12.dp))
        Text("Mundo Musical", style = MaterialTheme.typography.headlineLarge)
        Text("Instrumentos Musicais do Mundo")

        Spacer(Modifier.height(28.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it; viewModel.clearError() },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    "E-mail",
                    color = Color.DarkGray
                )
            },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black
            ),
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it; viewModel.clearError() },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Senha", color = Color.DarkGray) },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        state.error?.let {
            Spacer(Modifier.height(10.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { viewModel.login(email, password, onLoginSuccess) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.loading
        ) {
            if (state.loading) CircularProgressIndicator()
            else Text("Entrar")
        }

        TextButton(onClick = onGoToSignup) {
            Text("Ainda não tenho conta")
        }
    }
}
