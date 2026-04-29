package com.example.prog7313_poe_part2

import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.content.Intent
import android.widget.Button
import data.database.AppDatabase



class Home : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var textViewUserName : TextView

    private lateinit var buttonDownloadStatement: Button
    private lateinit var buttonCategoryAmount : Button
    private lateinit var buttonRewards : Button
    private lateinit var buttonExpenseEntry : Button

    private lateinit var expenseSearch :Button
    private lateinit var buttonUserGoals : Button

    private lateinit var currentBalance : TextView

    private lateinit var db: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        db = AppDatabase.getDatabase(this)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textViewUserName = findViewById(R.id.textViewUserName)
        buttonDownloadStatement = findViewById(R.id.buttonDownloadStatement)
        buttonCategoryAmount = findViewById(R.id.buttonCategoryAmount)
        buttonRewards = findViewById(R.id.buttonRewards)
        currentBalance = findViewById(R.id.currentBalance)
        buttonExpenseEntry = findViewById(R.id.buttonExpenseEntry)
        expenseSearch = findViewById(R.id.expenseSearch)
        buttonUserGoals = findViewById(R.id.buttonUserGoals)
        getLoggedInUser()
        getCurrentBalance()


        buttonDownloadStatement.setOnClickListener {
            openStatementsPage()
        }

        buttonCategoryAmount.setOnClickListener {
            openCategoryAmountsPage()
        }
        buttonExpenseEntry.setOnClickListener {
            openExpenseEntryPage()
        }

        buttonRewards.setOnClickListener {
            openRewardsPage()
        }

        expenseSearch.setOnClickListener {
            openExpenseSearchPage()
        }
        buttonUserGoals.setOnClickListener {
            openUserGoalsPage()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    @SuppressLint("SetTextI18n")
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


    private fun openStatementsPage(){
        val intent= Intent(this, Statements::class.java)
        startActivity(intent)

    }
    private fun openRewardsPage(){
        val intent= Intent(this, Rewards::class.java)
        startActivity(intent)

    }

    private fun openCategoryAmountsPage(){
        val intent= Intent(this, CategoryAmounts::class.java)
        startActivity(intent)

    }
    private fun openExpenseEntryPage(){
        val intent= Intent(this, AddExpense::class.java)
        startActivity(intent)

    }
    private fun openExpenseSearchPage(){
        val intent= Intent(this, ExpenseSearch::class.java)
        startActivity(intent)

    }

    private fun openUserGoalsPage(){
        val intent= Intent(this, UserGoals::class.java)
        startActivity(intent)

    }

}