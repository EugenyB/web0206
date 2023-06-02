package com.example.web0206.services

import com.example.web0206.data.Student
import org.springframework.stereotype.Service

@Service
class StudentService {
    private val students: MutableList<Student> = ArrayList()
    fun addStudent(student: Student) {
        students.add(student)
    }

    fun findAll(): List<Student> {
        return students
    }
}
