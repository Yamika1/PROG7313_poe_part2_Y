package com.example.prog7313_poe_part2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import data.CycleGoal
import data.database.AppDatabase
import kotlinx.coroutines.launch

class UserGoals : AppCompatActivity() {

    private lateinit var minimum: EditText
    private lateinit var maximum: EditText
    private lateinit var save: Button
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_goals)

        db = AppDatabase.getDatabase(this)

        minimum = findViewById(R.id.minimum)
        maximum = findViewById(R.id.maximum)
        save = findViewById(R.id.save)

        save.setOnClickListener {
            saveGoals()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun saveGoals() {
        val minText = minimum.text.toString().trim()
        val maxText = maximum.text.toString().trim()

        if (minText.isEmpty() || maxText.isEmpty()) {
            Toast.makeText(this, "Please enter both minimum and maximum goals", Toast.LENGTH_SHORT).show()
            return
        }

        val minGoal = minText.toDoubleOrNull()
        val maxGoal = maxText.toDoubleOrNull()

        if (minGoal == null || maxGoal == null) {
            Toast.makeText(this, "Please enter valid goal amounts", Toast.LENGTH_SHORT).show()
            return
        }

        if (minGoal > maxGoal) {
            Toast.makeText(this, "Minimum goal cannot be greater than maximum goal", Toast.LENGTH_SHORT).show()
            return
        }

        val currentMonth = java.text.SimpleDateFormat("MMMM yyyy", java.util.Locale.getDefault())
            .format(java.util.Date())

        lifecycleScope.launch {
            val existingGoal = db.cycleDao().getLatestCycleGoal()

            if (existingGoal == null) {
                val newGoal = CycleGoal(
                    minGoal = minGoal,
                    maxGoal = maxGoal,
                    month = currentMonth
                )
                db.cycleDao().insertCycleGoal(newGoal)
            } else {
                val updatedGoal = existingGoal.copy(
                    minGoal = minGoal,
                    maxGoal = maxGoal
                )
                db.cycleDao().updateCycleGoal(updatedGoal)
            }

            Toast.makeText(this@UserGoals, "Goals saved successfully", Toast.LENGTH_SHORT).show()

            minimum.text.clear()
            maximum.text.clear()
        }
    }
}