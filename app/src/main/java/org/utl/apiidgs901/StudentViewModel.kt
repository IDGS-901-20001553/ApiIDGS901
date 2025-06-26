package org.utl.apiidgs901

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    var state by mutableStateOf(StudentState())
        private set

    var response : List<Student> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                isloading = true)

            val apiService = ApiService.getInstance()
            val studentList = apiService.getStudents()
            response = studentList

            state = state.copy( isloading = false, students = response)
        }
    }
}