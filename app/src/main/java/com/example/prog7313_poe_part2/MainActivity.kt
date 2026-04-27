package com.example.prog7313_poe_part2

import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    private lateinit var textView: TextView
    private lateinit var editTextText: EditText
    private lateinit var editTextText2: EditText
    private lateinit var button: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editTextText = findViewById(R.id.editTextText)
        editTextText2 = findViewById(R.id.editTextText2)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)


        textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        button.setOnClickListener {
            login()
        }
    }


    private fun login() {
        val username = editTextText.text.toString().trim()
        val password = editTextText2.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Enter the username and password", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Hello $username :)", Toast.LENGTH_SHORT).show()
        }
    }
}
