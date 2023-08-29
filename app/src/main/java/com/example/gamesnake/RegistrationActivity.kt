package com.example.gamesnake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistrationActivity : AppCompatActivity(),  View.OnClickListener {
    lateinit var username : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        username = findViewById(R.id.username)
        var sign_up_btn: View = findViewById(R.id.signup_btn)
        sign_up_btn.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_to_menu1 -> {
                finish()
            }
            R.id.sign_in -> {
                val intent = Intent(applicationContext, RegLogActivity::class.java)
                startActivity(intent)
            }
            R.id.signup_btn -> {
                var username_ : String = username.getText().toString()
                Toast.makeText(this, "Username is " + username_, Toast.LENGTH_SHORT).show()
            }
        }
    }


}