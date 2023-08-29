package com.example.gamesnake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RegLogActivity : AppCompatActivity(),   View.OnClickListener {
    lateinit var username1 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_log)

        username1 = findViewById(R.id.username1)
        var sign_in_btn: View = findViewById(R.id.sign_in_log)
        sign_in_btn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_to_menu3 -> {
                finish()
            }
        }
    }
}