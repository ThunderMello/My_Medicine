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
//import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rosas.luis.mymedicine.R // Asegúrate de tener la ruta correcta

@OptIn(ExperimentalMaterial3Api::class) // Opt-in para APIs experimentales
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreen(navController: NavController) {
    // Variables de estado para cada campo
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var bloodType by remember { mutableStateOf("") }
    var diseases by remember { mutableStateOf("") }

    // Estado para mostrar errores
    var firstNameError by remember { mutableStateOf(false) }
    var lastNameError by remember { mutableStateOf(false) }
    var bloodTypeError by remember { mutableStateOf(false) }
    var diseasesError by remember { mutableStateOf(false) }

    // Lista de tipos de sangre
    val bloodTypes = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    var expanded by remember { mutableStateOf(false) } // Estado para desplegar menú

    // Verificar si el formulario es válido
    val isFormValid = remember(firstName, lastName, bloodType, diseases) {
        firstName.isNotBlank() && lastName.isNotBlank() && bloodType.isNotBlank() && diseases.isNotBlank()
    }

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

            // Campo de nombre
            TextField(
                value = firstName,
                onValueChange = {
                    firstName = it
                    firstNameError = firstName.isBlank()
                },
                label = { Text("Nombre(s)") },
                isError = firstNameError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (firstNameError) {
                Text(
                    text = "El nombre no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Campo de apellido
            TextField(
                value = lastName,
                onValueChange = {
                    lastName = it
                    lastNameError = lastName.isBlank()
                },
                label = { Text("Apellido(s)") },
                isError = lastNameError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (lastNameError) {
                Text(
                    text = "El apellido no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Selector de tipo de sangre con DropdownMenu
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = bloodType,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo de Sangre") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    bloodTypes.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type) },
                            onClick = {
                                bloodType = type
                                expanded = false
                                bloodTypeError = bloodType.isBlank()
                            }
                        )
                    }
                }
            }
            if (bloodType.isBlank()) {
                Text(
                    text = "Debe seleccionar un tipo de sangre",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Campo de enfermedades
            TextField(
                value = diseases,
                onValueChange = {
                    diseases = it
                    diseasesError = diseases.isBlank()
                },
                label = { Text("Enfermedades") },
                isError = diseasesError,
                modifier = Modifier.fillMaxWidth()
            )
            if (diseasesError) {
                Text(
                    text = "Las enfermedades no pueden estar vacías",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Botón para registrar, habilitado solo si el formulario es válido
            Button(
                onClick = {
                    if (isFormValid) {
                        // Navegar a la siguiente pantalla
                        navController.navigate("home")
                    }
                },
                enabled = isFormValid,
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
