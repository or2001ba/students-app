package com.or2001ba.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.or2001ba.studentsapp.adapters.StudentAdapter

class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val studentList: RecyclerView = findViewById(R.id.student_list)
        studentList.adapter = createAdapter()

        val addStudentButton: Button = findViewById(R.id.add_student_button)

        addStudentButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<RecyclerView>(R.id.student_list).adapter = createAdapter()
    }

    private fun createAdapter(): StudentAdapter {
        return StudentAdapter { studentId ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        }
    }
}
