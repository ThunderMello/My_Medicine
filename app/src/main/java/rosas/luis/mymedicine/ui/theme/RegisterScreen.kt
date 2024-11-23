package rosas.luis.mymedicine.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rosas.luis.mymedicine.R // Cambia por el paquete donde está tu imagen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreen(navController: NavController) {
    // Variables de estado para cada campo
    var name by remember { mutableStateOf("") }
    var bloodType by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }
    var diseases by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.appfondo), // Reemplaza con el ID correcto
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3f // Ajusta la transparencia
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(
                    color = Color.White.copy(alpha = 0.10f), // Fondo semi-transparente para destacar los campos
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro de Usuario",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre completo") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = bloodType,
                onValueChange = { bloodType = it },
                label = { Text("Tipo de sangre") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = allergies,
                onValueChange = { allergies = it },
                label = { Text("Alergias") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = diseases,
                onValueChange = { diseases = it },
                label = { Text("Enfermedades") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Navegar a la siguiente pantalla
                    navController.navigate("home")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Registrar", fontSize = 16.sp)
            }
        }
    }
}