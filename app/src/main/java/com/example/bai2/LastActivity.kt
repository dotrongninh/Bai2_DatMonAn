package com.example.bai2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class LastActivity : AppCompatActivity() {
    private lateinit var viewModel: LastViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_last)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(LastViewModel::class.java)

        val selectedFoodsTextView = findViewById<TextView>(R.id.selectedFoodsTextView)
        Log.d("bbb",viewModel.getSecondFood().toString())

//        viewModel.selectedFoods.observe(this) { selectedFoods ->
//            // Cập nhật giao diện hiển thị
//            selectedFoodsTextView.text = viewModel.getSecondFood() + " jfhsdufkhnf"
//                //selectedFoods.joinToString("\n")
        val selectedFoods = intent.getStringArrayListExtra("list") ?: listOf()
        selectedFoodsTextView.text = selectedFoods.joinToString("\n")
        }
    }
