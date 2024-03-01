package com.kaylr.ex2evionutfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.kaylr.ex2evionutfc.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var room: StudentDB
    private lateinit var adapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        room=getRoom()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillDatabase()
        initUI()
    }
    private fun fillDatabase(){
        val names: List<String> = listOf("Briseida", "Anacleto", "Macaria", "Uldarico", "Pascasia", "Inolfo", "Pancracio", "Espaminondo", "Gervasio", "Patrocinio", "Hermenegilda", "Crescencio", "Cristobalina", "Agapito", "Tesifonte",   "Petronila", "Torcuato", "Vitorio", "Isidra", "Sibilia", "Ambrosio", "Delfina", "Tiburcio", "Margarito",   "Filemón", "Crisóloga", "Casimiro", "Cananea", "Felipa", "Cojoncio" )
        val grades: List<Double> = listOf(5.2, 4.3, 9.8, 6.7, 7.8, 5.0, 8.9, 9.7, 10.0, 2.3, 3.5, 6.4, 8.4, 9.2, 1.3, 4.9,   5.7, 6.2, 8.5, 9.9, 2.5, 4.6, 5.8, 9.7, 6.8, 8.2, 8.9, 6.4, 4.0, 10.0)

        CoroutineScope(Dispatchers.IO).launch {
            val students = mutableListOf(
                Student(names[0], grades[0])
            )
            for (i in 1..29) {
                students.add(Student(names[i], grades[i]))
            }
            val studentList = students.map { it.toDatabase() }

            room.getStudentDao().deleteAllStudents()
            room.getStudentDao().insertAll(studentList)

        }
    }
    private fun initUI(){
        adapter = StudentsAdapter()//se inicializa vacío
        binding.rvAlumnos.setHasFixedSize(true)
        binding.rvAlumnos.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.rvAlumnos.adapter = adapter

        binding.btnTodosAlumnos.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                adapter.updateList(room.getStudentDao().getAllStudents())
            }
        }
        binding.btnAprobados.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                adapter.updateList(room.getStudentDao().getAprobados())
            }
        }
        binding.btnSuspensos.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                adapter.updateList(room.getStudentDao().getSuspensos())
            }
        }
    }

    private fun getRoom(): StudentDB{
        return Room
            .databaseBuilder(this, StudentDB::class.java, "StudentDB")
            .build()
    }
}