package com.example.gamesnake

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class GameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameView = findViewById(R.id.game_view)

        var up_arrow: View = findViewById(R.id.up_arrow)
        up_arrow.setOnClickListener(this)
        var down_arrow: View = findViewById(R.id.down_arrow)
        down_arrow.setOnClickListener(this)
        var left_arrow: View = findViewById(R.id.left_arrow)
        left_arrow.setOnClickListener(this)
        var right_arrow: View = findViewById(R.id.right_arrow)
        right_arrow.setOnClickListener(this)

        var score_view: TextView = findViewById(R.id.score_view)
        gameView.SetScore(score_view)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back_to_menu -> {
                finish()
            }

            R.id.left_arrow -> {
                gameView.ChangeSnakeDirection("LEFT")
            }

            R.id.right_arrow -> {
                gameView.ChangeSnakeDirection("RIGHT")
            }

            R.id.up_arrow -> {
                gameView.ChangeSnakeDirection("UP")
            }

            R.id.down_arrow -> {
                gameView.ChangeSnakeDirection("DOWN")
            }

            R.id.restart -> {
                val intent = Intent(this, GameOverActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
