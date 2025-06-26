package org.utl.apiidgs901

data class StudentState(
    val students: List<Student> = emptyList(),
    val isloading: Boolean = false
)
