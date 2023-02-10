package com.example.tasklist

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.green
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tasklist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val taskList: TaskList = TaskList()
    private lateinit var editText: EditText
    private lateinit var rcView: RecyclerView
    private lateinit var button: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val taskList = TaskList()
        this.editText = findViewById(R.id.editText)
        val adapter = Adapter(taskList)
        this.rcView = findViewById(R.id.rcView)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapter
        this.button = findViewById(R.id.button)
        this.button.setOnClickListener {
            taskList.addTask(Task(editText.text.toString(),false))
            editText.setText("")
            adapter.notifyDataSetChanged()
        }
    }
}