package com.demo.country

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()

        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "registartion") {
            composable(route = "registartion") {
                registarationScreen{
                    navController.navigate("main/${it}")
                }
            }
            composable(route = "login") {
                loginScreen()
            }
            composable(route = "main/{email}", arguments = listOf(
                navArgument("email"){
                type = NavType.StringType
            })) {
                val email = it.arguments!!.getString("email")
                if (email != null) {
                    mainScreen(email)
                }
            }
            // Add more destinations similarly.
        }
    }


    @Composable
    fun registarationScreen(onClick : (email : String)->Unit) {
        Text(text = "Registration", style = MaterialTheme.typography.h1,
            modifier = Modifier.clickable {
                onClick("supriyag75@gmai.com")
            })
    }

    @Composable
    fun loginScreen() {
        Text(text = "Login", style = MaterialTheme.typography.h1)
    }

    @Composable
    fun mainScreen(email : String) {
        Text(text = "Main ---- ${email}", style = MaterialTheme.typography.h1)
    }

}





