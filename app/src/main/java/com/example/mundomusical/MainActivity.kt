package com.example.mundomusical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mundomusical.ui.theme.MundoMusicalTheme

private const val LOGIN = "login"
private const val SIGNUP = "signup"
private const val HOME = "home"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MundoMusicalTheme {
                MundoMusicalApp()
            }
        }
    }
}

@Composable
private fun MundoMusicalApp() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(navController = navController, startDestination = LOGIN) {
        composable(LOGIN) {
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(HOME) {
                        popUpTo(LOGIN) { inclusive = true }
                    }
                },
                onGoToSignup = { navController.navigate(SIGNUP) }
            )
        }
        composable(SIGNUP) {
            SignupScreen(
                viewModel = authViewModel,
                onSignupSuccess = {
                    navController.navigate(HOME) {
                        popUpTo(LOGIN) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(HOME) {
            HomeScreen(
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(LOGIN) {
                        popUpTo(HOME) { inclusive = true }
                    }
                }
            )
        }
    }
}
