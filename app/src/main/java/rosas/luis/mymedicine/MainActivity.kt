package rosas.luis.mymedicine

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
/*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
*/
import androidx.compose.runtime.Composable
/*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
*/
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rosas.luis.mymedicine.ui.theme.LoginScreen
import rosas.luis.mymedicine.ui.theme.MedicinesListScreen
import rosas.luis.mymedicine.ui.theme.MedicinesScreen
/*
import rosas.luis.mymedicine.ui.theme.MyMedicineTheme
import RegisterScreen
*/
import androidx.compose.ui.platform.LocalContext
import rosas.luis.mymedicine.data.database.AppDatabase
import rosas.luis.mymedicine.ui.theme.HomeScreen
/*
import rosas.luis.mymedicine.data.repository.MedicineRepository
import rosas.luis.mymedicine.data.repository.UserRepository
import rosas.luis.mymedicine.ui.theme.LoginScreen
import rosas.luis.mymedicine.ui.theme.MedicinesListScreen
import rosas.luis.mymedicine.ui.theme.MedicinesScreen
*/
import rosas.luis.mymedicine.ui.theme.RegisterScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("medicines") { MedicinesScreen(navController) }
        composable("medicinesList") { MedicinesListScreen(navController) }
        // ... otras pantallas
    }
}


@Composable
fun ExampleScreen() {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)

    // Ahora puedes usar la base de datos
}
