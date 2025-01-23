package com.or2001ba.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.or2001ba.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        intent.getStringExtra("studentId")?.let { studentId ->
            loadStudentDetails(studentId)

            findViewById<Button>(R.id.edit_button).setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("studentId", studentId)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        intent.getStringExtra("studentId")?.let { studentId ->
            loadStudentDetails(studentId)
        }
    }

    private fun loadStudentDetails(studentId: String) {
        Model.getInstance().getStudentById(studentId)?.let {
            findViewById<TextView>(R.id.name_text).text = it.name
            findViewById<TextView>(R.id.id_text).text = it.id
            findViewById<TextView>(R.id.phone_text).text = it.phone
            findViewById<TextView>(R.id.address_text).text = it.address
            findViewById<CheckBox>(R.id.check).isChecked = it.checked
        } ?: run {
            finish()
        }
    }
}
