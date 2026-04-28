package com.example.prog7313_poe_part2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.content.Intent
import data.database.AppDatabase



class Home : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var textViewUserName : TextView

    private lateinit var currentBalance : TextView

    private lateinit var db: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        textViewUserName = findViewById(R.id.textViewUserName)

        getLoggedInUser()

        currentBalance = findViewById(R.id.currentBalance)


        db = AppDatabase.getDatabase(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun getCurrentBalance() {
        lifecycleScope.launch {
            val total = db.costDao().getTotalBalance() ?: 0.0
            runOnUiThread {
                currentBalance.text = "CURRENT BALANCE: R%.2f".format(total)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun getLoggedInUser(){
        val username = intent.getStringExtra("username")
        textViewUserName.text = "LOGGED IN AS: $username"
    }


    private fun openStatementsPage(username:String){
        val intent= Intent(this, Statements::class.java)
        startActivity(intent)
        finish()
    }
    private fun openBudgetEntryPage(username:String){
        //val intent= Intent(this,Home::class.java)
        startActivity(intent)
        finish()
    }

    private fun openExpenseSearchPage(username:String){
        //val intent= Intent(this,Home::class.java)
        startActivity(intent)
        finish()
    }

}