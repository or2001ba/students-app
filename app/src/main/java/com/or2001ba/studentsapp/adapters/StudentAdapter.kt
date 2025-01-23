package com.or2001ba.studentsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.or2001ba.studentsapp.R
import com.or2001ba.studentsapp.models.Model

class StudentAdapter(private val onItemClickListener: OnItemClicked) : RecyclerView.Adapter<StudentViewHolder>() {
    fun interface OnItemClicked {
        fun onItemClicked(studentId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(Model.getInstance().getStudents()[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return Model.getInstance().getStudentsCount()
    }
}
