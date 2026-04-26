package com.example.prog7313_poe_part2

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)
        textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        val emailInput = findViewById<EditText>(R.id.editTextText)
        val passwordInput = findViewById<EditText>(R.id.editTextText2)
        val buttonMessage = findViewById<Button>(R.id.button)


        buttonMessage.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Hello $email :)", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter the email and password", Toast.LENGTH_SHORT).show()





                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }
            }
        }
    }
}