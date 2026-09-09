package com.example.mundomusical

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AuthUiState(
    val loading: Boolean = false,
    val error: String? = null
)

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = AuthUiState(error = "Preencha e-mail e senha.")
            return
        }
        _uiState.value = AuthUiState(loading = true)
        auth.signInWithEmailAndPassword(email.trim(), password)
            .addOnSuccessListener {
                _uiState.value = AuthUiState()
                onSuccess()
            }
            .addOnFailureListener {
                _uiState.value = AuthUiState(
                    error = "Não foi possível entrar. Verifique o e-mail e a senha."
                )
            }
    }

    fun signup(email: String, password: String, onSuccess: () -> Unit) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = AuthUiState(error = "Preencha e-mail e senha.")
            return
        }
        if (password.length < 6) {
            _uiState.value = AuthUiState(error = "A senha deve ter pelo menos 6 caracteres.")
            return
        }
        _uiState.value = AuthUiState(loading = true)
        auth.createUserWithEmailAndPassword(email.trim(), password)
            .addOnSuccessListener {
                _uiState.value = AuthUiState()
                onSuccess()
            }
            .addOnFailureListener {
                _uiState.value = AuthUiState(
                    error = "Não foi possível criar a conta. Verifique os dados."
                )
            }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun logout() {
        auth.signOut()
    }
}
