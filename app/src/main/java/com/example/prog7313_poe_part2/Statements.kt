package com.example.prog7313_poe_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Statements : AppCompatActivity() {

    private lateinit var search_button: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.statements)


        search_button = findViewById(R.id.search_button)
        search_button.setOnClickListener() {


        }
        val getToActivity = findViewById<ImageButton>(R.id.backbutton)
        getToActivity.setOnClickListener {
            val intent = Intent(getApplicationContext(), MainActivity::class.java)
            startActivity(intent)
        }

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

