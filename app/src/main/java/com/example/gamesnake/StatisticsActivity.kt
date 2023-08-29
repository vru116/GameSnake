package com.example.gamesnake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StatisticsActivity : AppCompatActivity() ,  View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_to_menu2 -> {
                finish()
            }
        }
    }
}