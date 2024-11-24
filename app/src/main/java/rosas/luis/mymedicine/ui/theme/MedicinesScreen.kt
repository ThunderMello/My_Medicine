package rosas.luis.mymedicine.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rosas.luis.mymedicine.R // Asegúrate de que este sea el paquete correcto para la imagen

@Composable
fun MedicinesScreen(navController: NavController) {
    var medicineName by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var schedule by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }

    // Estados para mostrar errores
    var medicineNameError by remember { mutableStateOf(false) }
    var dosageError by remember { mutableStateOf(false) }
    var scheduleError by remember { mutableStateOf(false) }

    // Validar si el formulario está completo
    val isFormValid = remember(medicineName, dosage, schedule) {
        medicineName.isNotBlank() && dosage.toIntOrNull() != null && schedule.isNotBlank()
    }

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

            // Campo de nombre del medicamento
            TextField(
                value = medicineName,
                onValueChange = {
                    medicineName = it
                    medicineNameError = medicineName.isBlank()
                },
                label = { Text("Nombre del medicamento") },
                isError = medicineNameError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (medicineNameError) {
                Text(
                    text = "El nombre no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Campo de dosis
            TextField(
                value = dosage,
                onValueChange = {
                    dosage = it
                    dosageError = dosage.toIntOrNull() == null
                },
                label = { Text("Dosis (e.g., 500 mg)") },
                isError = dosageError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (dosageError) {
                Text(
                    text = "La dosis debe ser un número válido",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Campo de horario
            TextField(
                value = schedule,
                onValueChange = {
                    schedule = it
                    scheduleError = schedule.isBlank()
                },
                label = { Text("Horario (e.g., Cada 8 horas)") },
                isError = scheduleError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (scheduleError) {
                Text(
                    text = "El horario no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Campo de observaciones (sin validación requerida)
            TextField(
                value = observations,
                onValueChange = { observations = it },
                label = { Text("Observaciones") },
                maxLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Botón para guardar el medicamento, solo habilitado si el formulario es válido
            Button(
                onClick = {
                    if (isFormValid) {
                        // Guardar información y navegar
                        navController.navigate("medicinesList")
                    }
                },
                enabled = isFormValid,
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
