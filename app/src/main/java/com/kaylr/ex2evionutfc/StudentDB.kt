package com.kaylr.ex2evionutfc

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentDB: RoomDatabase() {
    abstract fun getStudentDao(): StudentDao
}