package com.kaylr.ex2evionutfc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter( private var studentList: List<StudentEntity> = emptyList())
    : RecyclerView.Adapter<StudentsViewHolder>() {
    fun updateList(list: List<StudentEntity>) {
        this.studentList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        return StudentsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }
    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(studentList[position])
    }
    override fun getItemCount() = studentList.size
}