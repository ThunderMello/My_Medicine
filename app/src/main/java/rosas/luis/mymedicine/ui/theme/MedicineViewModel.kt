package rosas.luis.mymedicine.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import rosas.luis.mymedicine.data.entities.Medicine
import rosas.luis.mymedicine.data.repository.MedicineRepository
import kotlinx.coroutines.launch

class MedicineViewModel(private val repository: MedicineRepository) : ViewModel() {

    fun addMedicine(medicine: Medicine) {
        viewModelScope.launch {
            repository.insertMedicine(medicine)
        }
    }

    fun getAllMedicines(callback: (List<Medicine>) -> Unit) {
        viewModelScope.launch {
            val medicines = repository.getAllMedicines()
            callback(medicines)
        }
    }
}