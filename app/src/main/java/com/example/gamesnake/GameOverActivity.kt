package com.example.gamesnake

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameOverActivity : AppCompatActivity(), View.OnClickListener {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val score = intent.getIntExtra("score", 0)

        val score_text = findViewById<TextView>(R.id.score_text)
        score_text.text = "Score : $score"
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.restart -> {
                val intent = Intent(applicationContext, GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}