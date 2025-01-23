package com.or2001ba.studentsapp.models

class Model private constructor() {
    companion object {
        private val instance = Model()

        fun getInstance(): Model {
            return instance
        }
    }

    private val students = mutableListOf(
        Student("111111111", "Liam Johnson", "052-1111111", "King George 5, Tel Aviv"),
        Student("222222222", "Emma Roberts", "052-2222222", "Rothschild 12, Haifa"),
        Student("333333333", "Noah Williams", "052-3333333", "Allenby 45, Jerusalem"),
        Student("444444444", "Olivia Brown", "052-4444444", "Ben Yehuda 67, Tel Aviv"),
        Student("555555555", "William Jones", "052-5555555", "Hagana 23, Ashdod"),
        Student("666666666", "Sophia Garcia", "052-6666666", "Shenkin 10, Tel Aviv"),
        Student("777777777", "James Martinez", "052-7777777", "Dizengoff 88, Tel Aviv"),
        Student("888888888", "Isabella Clark", "052-8888888", "Hertzl 3, Ramat Gan"),
        Student("999999999", "Benjamin Lewis", "052-9999999", "Bograshov 19, Rosh Haayin"),
        Student("000000000", "Mia Walker", "052-0000000", "Frug 15, Tel Aviv")
    )

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun getStudents(): List<Student> {
        return students
    }

    fun getStudentsCount(): Int {
        return students.size
    }

    fun getStudentById(studentId: String): Student? {
        return students.find { it.id == studentId }
    }

    fun updateStudentById(studentId: String, student: Student) {
        val index = students.indexOfFirst { it.id == studentId }

        if (index != -1) {
            students[index] = student
        }
    }

    fun deleteStudentById(studentId: String) {
        students.removeIf { it.id == studentId }
    }
}
