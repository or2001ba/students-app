package com.or2001ba.studentsapp.adapters

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.or2001ba.studentsapp.R
import com.or2001ba.studentsapp.models.Student

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.studentName)
    private val id: TextView = itemView.findViewById(R.id.studentId)
    private val checkBox: CheckBox = itemView.findViewById(R.id.studentCheck)

    fun bind(student: Student, onItemClickListener: StudentAdapter.OnItemClicked) {
        name.text = student.name
        id.text = student.id
        checkBox.isChecked = student.checked

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            student.checked = isChecked
        }

        itemView.setOnClickListener {
            onItemClickListener.onItemClicked(student.id)
        }
    }
}
