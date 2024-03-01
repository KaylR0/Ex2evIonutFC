package com.kaylr.ex2evionutfc

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.ex2evionutfc.databinding.ItemLayoutBinding

class StudentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemLayoutBinding.bind(view)
    fun bind(studentEntity: StudentEntity) {
        //recibe los items de la lista
        binding.studentName.text = studentEntity.name
        binding.studentGrade.text = studentEntity.grade.toString()
    }
}