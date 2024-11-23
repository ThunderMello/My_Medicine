package rosas.luis.mymedicine.ui.theme

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
import rosas.luis.mymedicine.R // Cambia por el paquete correcto para la imagen

@Composable
fun MedicinesScreen(navController: NavController) {
    var medicineName by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var schedule by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Fondo de imagen con transparencia
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
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(
                    color = Color.White.copy(alpha = 0.10f), // Fondo semi-transparente
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registrar Medicamento",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                value = medicineName,
                onValueChange = { medicineName = it },
                label = { Text("Nombre del medicamento") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = dosage,
                onValueChange = { dosage = it },
                label = { Text("Dosis (e.g., 500 mg)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = schedule,
                onValueChange = { schedule = it },
                label = { Text("Horario (e.g., Cada 8 horas)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = observations,
                onValueChange = { observations = it },
                label = { Text("Observaciones") },
                maxLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Validar o guardar información
                    navController.navigate("medicinesList") // Navegar a la lista de medicamentos
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Guardar Medicamento", fontSize = 16.sp)
            }
        }
    }
}