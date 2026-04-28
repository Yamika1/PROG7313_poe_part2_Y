package com.example.prog7313_poe_part2

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Rewards : AppCompatActivity() {

    // global declarations

    private lateinit var progressXp: ProgressBar
    private lateinit var textViewLevel: TextView
    private lateinit var textViewXpPercent: TextView
    private lateinit var textViewXpCount: TextView
    private lateinit var textViewCreditScore: TextView
    private lateinit var buttonClaimReward: Button

    private var currentXp = 0
    private var maxXp = 2000
    private var currentLevel = 1
    private var creditScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)

        // typecasting
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
        val percent = ((currentXp.toDouble() / maxXp.toDouble()) * 100).toInt()

        progressXp.progress = percent
        textViewLevel.text = "Level$currentLevel"
        textViewXpPercent.text = "$percent% TOWARDS LEVEL ${currentLevel + 1}"
        textViewXpCount.text = "$currentXp / $maxXp XP"
        textViewCreditScore.text = "%,d".format(creditScore)
    }

    private fun claimReward() {
        currentXp += 50
        creditScore += 50

        if (currentXp >= maxXp) {
            currentLevel++
            currentXp -= maxXp
        }

        Toast.makeText(this, "Reward claimed successfully", Toast.LENGTH_SHORT).show()
        loadRewards()
    }
}