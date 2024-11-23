package rosas.luis.mymedicine.data.dao

import androidx.room.*
import rosas.luis.mymedicine.data.entities.Medicine

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicine_table WHERE id = :medicineId")
    suspend fun getMedicineById(medicineId: Int): Medicine?

    @Query("SELECT * FROM medicine_table")
    suspend fun getAllMedicines(): List<Medicine>

    @Delete
    suspend fun deleteMedicine(medicine: Medicine)
}