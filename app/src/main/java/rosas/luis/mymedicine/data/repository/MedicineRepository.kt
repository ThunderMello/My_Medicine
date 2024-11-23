package rosas.luis.mymedicine.data.repository

import rosas.luis.mymedicine.data.dao.MedicineDao
import rosas.luis.mymedicine.data.entities.Medicine

class MedicineRepository(private val medicineDao: MedicineDao) {

    suspend fun insertMedicine(medicine: Medicine) {
        medicineDao.insertMedicine(medicine)
    }

    suspend fun getMedicineById(medicineId: Int): Medicine? {
        return medicineDao.getMedicineById(medicineId)
    }

    suspend fun getAllMedicines(): List<Medicine> {
        return medicineDao.getAllMedicines()
    }

    suspend fun deleteMedicine(medicine: Medicine) {
        medicineDao.deleteMedicine(medicine)
    }
}
