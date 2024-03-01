package com.kaylr.ex2evionutfc

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM student_table")
    suspend fun getAllStudents():List<StudentEntity>

    @Query("SELECT * FROM student_table WHERE grade >= 5")
    suspend fun getAprobados():List<StudentEntity>

    @Query("SELECT * FROM student_table WHERE grade < 5")
    suspend fun getSuspensos():List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(student:List<StudentEntity>)

    @Query("DELETE FROM student_table")
    suspend fun deleteAllStudents()

}