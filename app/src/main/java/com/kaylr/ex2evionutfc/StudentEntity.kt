package com.kaylr.ex2evionutfc

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "grade") val grade: Double
)
fun Student.toDatabase() = StudentEntity(
    name = name,
    grade = grade,
)