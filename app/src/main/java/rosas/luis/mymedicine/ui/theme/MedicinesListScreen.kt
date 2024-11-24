package rosas.luis.mymedicine.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Medicine(
    val name: String,
    val dosage: String,
    val schedule: String,
    val observations: String
)

@Composable
fun MedicinesListScreen(navController: NavController) {
    // Lista de medicamentos simulada
    val medicines = remember {
        listOf(
            Medicine(
                name = "Paracetamol",
                dosage = "500 mg",
                schedule = "Cada 8 horas",
                observations = "Tomar después de las comidas"
            ),
            Medicine(
                name = "Ibuprofeno",
                dosage = "200 mg",
                schedule = "Cada 12 horas",
                observations = "No exceder 3 dosis al día"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lista de Medicamentos",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Renderizar la lista de medicamentos
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(medicines) { medicine ->
                MedicineCard(medicine)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para volver al registro
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Volver al inicio")
        }
    }
}

@Composable
fun MedicineCard(medicine: Medicine) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Elevación usando Material3
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Nombre: ${medicine.name}",
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Dosis: ${medicine.dosage}",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Horario: ${medicine.schedule}",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Observaciones: ${medicine.observations}",
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
            )
        }
    }
}