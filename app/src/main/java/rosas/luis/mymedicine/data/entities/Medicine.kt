package rosas.luis.mymedicine.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicine_table")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,  // ID autogenerado
    val name: String,          // Nombre del medicamento
    val dosage: String,        // Dosis del medicamento (e.g., 500 mg)
    val schedule: String,      // Horario de consumo (e.g., Cada 8 horas)
    val observations: String   // Observaciones adicionales
)
