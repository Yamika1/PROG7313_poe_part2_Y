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
import kotlinx.coroutines.launch

class Register : AppCompatActivity(){

    private lateinit var heading: TextView
    private lateinit var editTextFName: EditText
    private lateinit var editTextLName: EditText
    private lateinit var editTextUsername : EditText
    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText

    private lateinit var buttonLogin : Button

    private lateinit var buttonRegister : Button
    private lateinit var db: RoomDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        heading = findViewById(R.id.heading)
        editTextFName = findViewById(R.id.editTextFName)
        editTextLName = findViewById(R.id.editTextLName)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        heading.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        buttonLogin.setOnClickListener {
            openLoginScreen()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

        private fun registerUser() {
            //get the text from the input fields and remove extra spaces. Android studio doesn't except raw data, data that the user enters, it needs to be converted and stored in a variable first
            val firstName = editTextFName.text.toString().trim()
            val lastName = editTextLName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val userName = editTextUsername.text.toString().trim()  // spaces must be removed because the database could be sensitive to the spaces
            val password = editTextPassword.text.toString().trim()
            val confirmPassword = editTextConfirmPassword.text.toString().trim()

           db = RoomDatabase.getDatabase(this)

            buttonRegister.setOnClickListener {
                registerUser()
            }

            //button for when the users already have an account
            buttonLogin.setOnClickListener {
                openLoginScreen() //user will be directed to log in screen
            }

            //Validation
            //checks if the fields are empty

            if (firstName.isEmpty() || lastName.isEmpty()|| email.isEmpty() || userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return //stops function if validation fails

            }
            //check if passwords match
            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }

            //database operation
            //lifecycleScope.launch runs code in the background
            lifecycleScope.launch {


                //check first to see if the user already exists in the database
                val existingUser = db.userDao().getUserByUsername(userName)

                if (existingUser != null) {
                    //if user exists,show message on screen
                    runOnUiThread {
                        Toast.makeText(this@Register, "Username already exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    //if user does not exist, create a new user object

                    val newUser = User(
                        firstName = firstName,
                        lastName = lastName,
                        email = email,
                        username = userName,
                        password = password
                    )

                    //insert new user into the database
                    db.userDao().insertUser(newUser)

                    //show success message and move to login page
                    runOnUiThread {
                        Toast.makeText(this@Register, "Registration successful", Toast.LENGTH_SHORT)
                            .show()

                        clearFields()
                        openLoginScreen()
                    }
                }


            }
        }


        private fun openLoginScreen() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()

        }

        private fun clearFields(){
            editTextFName.text.clear()
            editTextLName.text.clear()
            editTextUsername.text.clear()
            editTextEmail.text.clear()
            editTextPassword.text.clear()
            editTextConfirmPassword.text.clear()
        }
    }
