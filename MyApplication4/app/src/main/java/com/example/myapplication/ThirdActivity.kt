package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {
    private lateinit var emailButton: Button
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        emailButton = findViewById(R.id.email_button)
        emailEditText = findViewById(R.id.email)

        val name = intent.extras?.getString("name")
        val age = intent.extras?.getInt("age")
        val email = intent.extras?.getString("email")

        emailButton.setOnClickListener {
            val email = emailEditText.text.toString()


            if (email.isEmpty()) {
                return@setOnClickListener
            }

            val intent = Intent(this,FinishActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("email", email)

            startActivity(intent)
        }
    }

}