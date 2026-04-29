package com.example.prog7313_poe_part2

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import data.database.AppDatabase
import kotlinx.coroutines.launch
import data.Cost


class Rewards : AppCompatActivity() {

    private lateinit var progressXp: ProgressBar
    private lateinit var textViewLevel: TextView
    private lateinit var textViewXpPercent: TextView
    private lateinit var textViewXpCount: TextView
    private lateinit var textViewCreditScore: TextView
    private lateinit var buttonClaimReward: Button

    private lateinit var db: AppDatabase

    private val maxXp = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rewards)

        db = AppDatabase.getDatabase(this)

        progressXp = findViewById(R.id.progressXp)
        textViewLevel = findViewById(R.id.textViewLevel)
        textViewXpPercent = findViewById(R.id.textViewXpPercent)
        textViewXpCount = findViewById(R.id.textViewXpCount)
        textViewCreditScore = findViewById(R.id.textViewCreditScore)
        buttonClaimReward = findViewById(R.id.buttonClaimReward)

        loadRewards()

        buttonClaimReward.setOnClickListener {
            claimReward()
        }
    }

    private fun loadRewards() {
        lifecycleScope.launch {
            val costs = db.costDao().getAllCosts()
            val latestCycle = db.cycleDao().getLatestCycleGoal()

            var totalSpent = 0.0

            for (cost in costs) {
                totalSpent += cost.amount
            }

            var xp = costs.size * 10

            if (latestCycle != null) {
                if (totalSpent <= latestCycle.maxGoal) {
                    xp += 50
                }
            }
            val level = (xp / maxXp) + 1
            val percent = ((xp % maxXp) * 100) / maxXp
            val creditScore = xp + totalSpent.toInt()

            runOnUiThread {
                progressXp.progress = percent
                textViewLevel.text = "Level $level"
                textViewXpPercent.text = "$percent% TOWARDS LEVEL ${level + 1}"
                textViewXpCount.text = "$xp / $maxXp XP"
                textViewCreditScore.text = "%,d".format(creditScore)
            }
        }
    }

    private fun claimReward() {
        Toast.makeText(this, "reward checked successfully", Toast.LENGTH_SHORT).show()
        loadRewards()
    }
}