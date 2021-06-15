package com.example.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var  firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        init()
    }

    private fun init() {
        sub.setOnClickListener{
            val mail: String = email.text.toString()
            val password: String = pass1.text.toString()
            val confirm: String = pass2.text.toString()
            if (validateEmail(mail ) && validatePass(password) && matchPass(password, confirm)) {
                firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        Toast.makeText(this, "მომხმარებელი წარმატებით შეიქმნა!", Toast.LENGTH_LONG).show()
                        email.setText("")
                        pass1.setText("")
                        pass2.setText("")
                    } else {
                        Toast.makeText(this, "დაფიქსირდა შეცდომა!", Toast.LENGTH_LONG).show()
                        email.setText("")
                        pass1.setText("")
                        pass2.setText("")
                    }
                }
            } else {
                Toast.makeText(this, "არასწორი ფორმატი", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateEmail(value: String) : Boolean {
        val emailRegex = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
        val validate = Pattern.compile(emailRegex)
        return validate.matcher(value).matches()
    }

    private fun validatePass(value: String) : Boolean {
        val passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{9,}$"
        val validate = Pattern.compile(passwordRegex)
        return validate.matcher(value).matches()

    }

    private fun matchPass( value1: String, value2: String) : Boolean {
        return value1 == value2
    }
}