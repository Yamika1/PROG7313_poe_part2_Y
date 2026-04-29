package com.example.prog7313_poe_part2

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import data.database.AppDatabase
import kotlinx.coroutines.launch

class ExpenseSearch : AppCompatActivity() {

    private lateinit var editTextStartDate: EditText
    private lateinit var editTextEndDate: EditText
    private lateinit var buttonSearch: Button
    private lateinit var textViewSearchResults: TextView
    private lateinit var results: LinearLayout
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_expense_search)

        db = AppDatabase.getDatabase(this)

        editTextStartDate = findViewById(R.id.editTextStartDate)
        editTextEndDate = findViewById(R.id.editTextEndDate)
        buttonSearch = findViewById(R.id.buttonSearch)
        results = findViewById(R.id.results)

        editTextStartDate.setOnClickListener {
            showDatePicker(isStartDate = true)
        }

        editTextEndDate.setOnClickListener {
            showDatePicker(isStartDate = false)
        }

        buttonSearch.setOnClickListener {
            searchExpenses()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showDatePicker(isStartDate: Boolean) {
        val calendar = Calendar.getInstance()

        DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedMonth = String.format("%02d", selectedMonth + 1)
                val formattedDay = String.format("%02d", selectedDay)
                val selectedDate = "$selectedYear-$formattedMonth-$formattedDay"

                if (isStartDate) editTextStartDate.setText(selectedDate)
                else editTextEndDate.setText(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun searchExpenses() {
        val startDate = editTextStartDate.text.toString()
        val endDate = editTextEndDate.text.toString()

        if (startDate.isEmpty() || endDate.isEmpty()) {
            Toast.makeText(this, "Please enter both start and end dates", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val expenseResults = db.costDao().getEntriesInRange(startDate, endDate)

            runOnUiThread {
                results.removeAllViews()

                if (expenseResults.isEmpty()) {
                    val noResultsText = TextView(this@ExpenseSearch).apply {
                        text = "No expenses found for the selected period"
                        textSize = 16f
                    }
                    results.addView(noResultsText)
                    return@runOnUiThread
                }

                for (expense in expenseResults) {
                    val expenseText = TextView(this@ExpenseSearch).apply {
                        text = "Category: ${expense.category}\n" +
                                "Amount: R${expense.amount}\n" +
                                "Date: ${expense.date}\n" +
                                "Description: ${expense.description}"
                        textSize = 16f
                    }
                    results.addView(expenseText)

                    if (expense.photoUri != null) {
                        val imageView = ImageView(this@ExpenseSearch).apply {
                            layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            adjustViewBounds = true
                            scaleType = ImageView.ScaleType.FIT_CENTER
                        }

                        try {
                            imageView.setImageURI(Uri.parse(expense.photoUri))
                            results.addView(imageView)
                        } catch (e: Exception) {
                            val imageErrorText = TextView(this@ExpenseSearch).apply {
                                text = "Image could not be loaded"
                                textSize = 14f
                            }
                            results.addView(imageErrorText)
                        }
                    }
                }
            }
        }
    }
}