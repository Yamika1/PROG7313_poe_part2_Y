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
import androidx.lifecycle.lifecycleScope
import data.database.AppDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var editTextText: EditText
    private lateinit var editTextText2: EditText
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var db: AppDatabase





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        db = AppDatabase.getDatabase(this)

        textView = findViewById(R.id.textView)
        editTextText = findViewById(R.id.editTextText)
        editTextText2 = findViewById(R.id.editTextText2)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        button.setOnClickListener {
            login()
        }

        button2.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun login(){
        val username = editTextText.text.toString().trim()
        val password= editTextText2.text.toString().trim()


        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Both username and password is needed", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {

            val foundUser = db.userDao().loginUser(username,password)

            runOnUiThread(){
                if (foundUser != null){

                    Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()


                    openHomePage(foundUser.username)

                }else{

                    Toast.makeText(this@MainActivity, "Invalid username or password.Please try again", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun openHomePage(username:String){
        val intent= Intent(this,Home::class.java)
        intent.putExtra("username", username)
        startActivity(intent)

    }
}
