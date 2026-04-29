package com.example.prog7313_poe_part2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Statements : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.statements)


        val getToActivity = findViewById<ImageButton>(R.id.btnBack)
        getToActivity.setOnClickListener {
            val intent = Intent(applicationContext, Home::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.scrollView2)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

