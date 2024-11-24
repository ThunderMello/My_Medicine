package rosas.luis.mymedicine.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID autogenerado
    val name: String,           // Nombre del usuario
    val bloodType: String,      // Tipo de sangre
    val allergies: String,      // Alergias
    val diseases: String        // Enfermedades
)