package com.example.socialsparkapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField = findViewById<TextInputEditText>(R.id.textInputTimeOfDay)
        val generateButton = findViewById<Button>(R.id.generateSocialSparkButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resultText = findViewById<TextView>(R.id.resultTextView)

        // Handles generate button click
        generateButton.setOnClickListener {

            //stores user input in a variable
            val userInput = inputField.text.toString().trim().lowercase()

            if (userInput == "morning") {
                resultText.text = "Send a \"Good Morning\" text to a family member."
            }
            else if (userInput == "mid-morning" || userInput == "mid morning") {
                resultText.text = "Reach out to a colleague with a quick \"Thank You!\" message."
            }
            else if (userInput == "afternoon") {
                resultText.text = "Share a funny meme or interesting link with a friend."
            }
            else if (userInput == "afternoon snack") {
                resultText.text = "Send a \"Thinking of you\" message to a friend or family member."
            }
            else if (userInput == "dinner") {
                resultText.text = "Call a friend or a family member for a 5-minute catch-up."
            }
            else if (userInput == "after dinner" || userInput == "night") {
                resultText.text = "Leave a thoughtful comment on a friend's post."
            }
            //Checks if user input is empty
            else if (userInput.isEmpty()) {
                resultText.text = "Please enter a time of day!"
                Toast.makeText(this, "Input cannot be empty!", Toast.LENGTH_SHORT).show()
            }
            else {
                resultText.text = "Try: morning, mid-morning, afternoon, snack time, dinner, or night"
                Toast.makeText(this, "Invalid input!", Toast.LENGTH_SHORT).show()
            }
        }

        // Reset button
        resetButton.setOnClickListener {
            inputField.text?.clear()
            resultText.text = ""
            Toast.makeText(this, "Reset successful", Toast.LENGTH_SHORT).show()
        }
    }
}