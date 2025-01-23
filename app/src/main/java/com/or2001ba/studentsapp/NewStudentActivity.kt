package com.or2001ba.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.or2001ba.studentsapp.models.Model
import com.or2001ba.studentsapp.models.Student

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.save_button).setOnClickListener {
            saveStudent()
            finish()
        }
    }

    private fun saveStudent() {
        val nameInput: EditText = findViewById(R.id.name_input)
        val idInput: EditText = findViewById(R.id.id_input)
        val phoneInput: EditText = findViewById(R.id.phone_input)
        val addressInput: EditText = findViewById(R.id.address_input)
        val checkBoxInput: CheckBox = findViewById(R.id.check_input)

        val newStudent = Student(
            idInput.text.toString(),
            nameInput.text.toString(),
            phoneInput.text.toString(),
            addressInput.text.toString(),
            checkBoxInput.isChecked
        )

        Model.getInstance().addStudent(newStudent)
    }
}
