package com.example.mundomusical
import androidx.compose.material3.LocalTextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

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

    Column(
        modifier = Modifier.fillMaxSize().padding(28.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Criar conta", style = MaterialTheme.typography.headlineLarge)
        Text("Cadastre-se para entrar no Mundo Musical.")
        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it; viewModel.clearError() },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("E-mail", color = Color.DarkGray) },
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
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it; viewModel.clearError() },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Confirmar senha", color = Color.DarkGray) },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        if (confirmPassword.isNotEmpty() && password != confirmPassword) {
            Spacer(Modifier.height(8.dp))
            Text("As senhas não coincidem.", color = MaterialTheme.colorScheme.error)
        }

        state.error?.let {
            Spacer(Modifier.height(8.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                if (password == confirmPassword) {
                    viewModel.signup(email, password, onSignupSuccess)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.loading && password.isNotEmpty() && password == confirmPassword
        ) {
            if (state.loading) CircularProgressIndicator()
            else Text("Criar conta")
        }

        TextButton(onClick = onBack) {
            Text("Voltar para o login")
        }
    }
}
