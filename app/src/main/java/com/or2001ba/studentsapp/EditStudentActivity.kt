package com.or2001ba.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.or2001ba.studentsapp.models.Model
import com.or2001ba.studentsapp.models.Student

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("studentId")

        if(studentId == null) {
            finish()
            return
        }

        loadStudentDetails(studentId)

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.save_button).setOnClickListener {
            updateStudentDetails(studentId)
        }

        findViewById<Button>(R.id.delete_button).setOnClickListener {
            deleteStudent(studentId)
        }
    }

    private fun loadStudentDetails(studentId: String) {
        Model.getInstance().getStudentById(studentId)?.let {
            findViewById<TextView>(R.id.name_input).text = it.name
            findViewById<TextView>(R.id.id_input).text = it.id
            findViewById<TextView>(R.id.phone_input).text = it.phone
            findViewById<TextView>(R.id.address_input).text = it.address
            findViewById<CheckBox>(R.id.check_input).isChecked = it.checked
        }
    }

    private fun updateStudentDetails(studentId: String) {
        val student = Student(
            findViewById<TextView>(R.id.id_input).text.toString(),
            findViewById<TextView>(R.id.name_input).text.toString(),
            findViewById<TextView>(R.id.phone_input).text.toString(),
            findViewById<TextView>(R.id.address_input).text.toString(),
            findViewById<CheckBox>(R.id.check_input).isChecked
        )
        Model.getInstance().updateStudentById(studentId, student)
        finish()
    }

    private fun deleteStudent(studentId: String) {
        Model.getInstance().deleteStudentById(studentId)
        finish()
    }
}
