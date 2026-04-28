package com.example.prog7313_poe_part2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CategoryAmounts : AppCompatActivity() {

    // global declarations

    private lateinit var textViewTotalSpent: TextView
    private lateinit var textViewCurrentMonth: TextView
    private lateinit var textViewTopCategory: TextView

    private lateinit var textViewGroceriesAmount: TextView
    private lateinit var textViewGroceriesCount: TextView

    private lateinit var textViewTransportAmount: TextView
    private lateinit var textViewTransportCount: TextView

    private lateinit var textViewEntertainmentAmount: TextView
    private lateinit var textViewEntertainmentCount: TextView

    private lateinit var textViewUtilitiesAmount: TextView
    private lateinit var textViewUtilitiesCount: TextView

    private lateinit var textViewOtherAmount: TextView
    private lateinit var textViewOtherCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_amounts)

        // typecasting
        textViewTotalSpent = findViewById(R.id.textViewTotalSpent)
        textViewCurrentMonth = findViewById(R.id.textViewCurrentMonth)
        textViewTopCategory = findViewById(R.id.textViewTopCategory)

        textViewGroceriesAmount = findViewById(R.id.textViewGroceriesAmount)
        textViewGroceriesCount = findViewById(R.id.textViewGroceriesCount)

        textViewTransportAmount = findViewById(R.id.textViewTransportAmount)
        textViewTransportCount = findViewById(R.id.textViewTransportCount)

        textViewEntertainmentAmount = findViewById(R.id.textViewEntertainmentAmount)
        textViewEntertainmentCount = findViewById(R.id.textViewEntertainmentCount)

        textViewUtilitiesAmount = findViewById(R.id.textViewUtilitiesAmount)
        textViewUtilitiesCount = findViewById(R.id.textViewUtilitiesCount)

        textViewOtherAmount = findViewById(R.id.textViewOtherAmount)
        textViewOtherCount = findViewById(R.id.textViewOtherCount)

        val monthName = SimpleDateFormat("MMMM", Locale.getDefault()).format(Date()).uppercase()
        textViewCurrentMonth.text = monthName

        loadCategoryData()
    }

    private fun loadCategoryData() {
        val groceries = 0.0
        val transport = 0.0
        val entertainment = 0.0
        val utilities = 0.0
        val other = 0.0

        val total = groceries + transport + entertainment + utilities + other

        textViewTotalSpent.text = "R%,.2f".format(total)
        textViewTopCategory.text = "-"

        textViewGroceriesAmount.text = "R%.2f".format(groceries)
        textViewGroceriesCount.text = "0 Transactions"

        textViewTransportAmount.text = "R%.2f".format(transport)
        textViewTransportCount.text = "0 Transactions"

        textViewEntertainmentAmount.text = "R%.2f".format(entertainment)
        textViewEntertainmentCount.text = "0 Transactions"

        textViewUtilitiesAmount.text = "R%.2f".format(utilities)
        textViewUtilitiesCount.text = "0 Transactions"

        textViewOtherAmount.text = "R%.2f".format(other)
        textViewOtherCount.text = "0 Transactions"
    }
}