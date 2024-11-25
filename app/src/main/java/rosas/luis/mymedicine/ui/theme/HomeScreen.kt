// archivo: HomeScreen.kt
package rosas.luis.mymedicine.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rosas.luis.mymedicine.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.ui.platform.LocalContext
import android.app.DatePickerDialog
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    // Obtener la fecha actual
    val currentDate = LocalDate.now()
    // Formatear la fecha para mostrarla
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", Locale.getDefault())
    val formattedDate = currentDate.format(formatter)

    // Acceder al contexto desde el Composable
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen de fondo con transparencia
        Image(
            painter = painterResource(id = R.drawable.appfondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3f // Ajustar transparencia para mejor contraste
        )

        // Columna con fondo semitransparente para mejorar contraste
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(
                    color = Color.White.copy(alpha = 0.8f), // Fondo semi-transparente
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar la fecha y el día actual con mayor visibilidad
            Text(
                text = formattedDate,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black, // Cambiar color para mejor visibilidad
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.9f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
            )

            // Botón para seleccionar fecha
            Button(
                onClick = { showDatePickerDialog(context) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)), // Color de botón contrastante
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Seleccionar Fecha", color = Color.White)
            }

            Button(
                onClick = { navController.navigate("medicines") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5)), // Otro color contrastante
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Registrar medicamento", color = Color.Black)
            }

            Button(
                onClick = { navController.navigate("medicinesList") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5)), // Mantener consistencia en color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Ver tus medicamentos", color = Color.Black)
            }

            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)), // Color de botón contrastante para "Salir"
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Salir", color = Color.White)
            }
        }
    }
}

// Función para mostrar el DatePickerDialog
fun showDatePickerDialog(context: android.content.Context) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            // Aquí puedes manejar la fecha seleccionada
        },
        year,
        month,
        day
    )
    datePickerDialog.show()
}
