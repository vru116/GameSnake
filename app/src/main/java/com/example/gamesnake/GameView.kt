package com.example.gamesnake

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class GameView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var snake: Snake = Snake(Point(0, 0))
    var apple: Point = Point(0, 0)

    var score: Int = 0
    var score_view: TextView? = null
    var game_over: Boolean = false

    init {
        snake = Snake(Point(10, 10))
        var x = (0..20).random()
        var y = (0..26).random()
        apple = Point(x, y)

        var runnable = object : Runnable {
            override fun run() {
                UpdateGame()
                postDelayed(this, FRAME_RATE.toLong())
            }
        }

        runnable.run()
    }


    fun SetScore(score_text: TextView) {
        score_view = score_text
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var paint_snake: Paint = Paint()
        paint_snake.color = Color.WHITE
        var paint_apple: Paint = Paint()
        paint_apple.color = Color.MAGENTA
        for (part in snake.GetSnakeBody()) {
            canvas.drawRect(
                part.x * 50F,
                part.y * 50F,
                (part.x + 1) * 50F,
                (part.y + 1) * 50F,
                paint_snake
            )
        }
        canvas.drawRect(
            apple.x * 50F,
            apple.y * 50F,
            (apple.x + 1) * 50F,
            (apple.y + 1) * 50F,
            paint_apple
        )
    }

    fun ChangeSnakeDirection(new_direction: String) {
        if ((snake.GetSnakeDirection() == "UP" && (new_direction == "RIGHT" || new_direction == "LEFT"))
            || (snake.GetSnakeDirection() == "DOWN" && (new_direction == "RIGHT" || new_direction == "LEFT"))
            || (snake.GetSnakeDirection() == "RIGHT" && (new_direction == "UP" || new_direction == "DOWN"))
            || (snake.GetSnakeDirection() == "LEFT" && (new_direction == "UP" || new_direction == "DOWN"))
        ) {
            snake.SetSnakeDirection(new_direction)
        }
    }

    @SuppressLint("SetTextI18n")
    fun UpdateGame() {
        if (game_over) {
            return
        } else {
            snake.MoveSnake()

            var collision: Boolean = false
            for (i in 1 until snake.GetSnakeBody().size) {
                if (snake.GetSnakeBody()[0].IsEqual(snake.GetSnakeBody()[i])) {
                    collision = true
                    break
                }
            }

            if (collision) {
                game_over = true
                val intent = Intent(context, GameOverActivity::class.java)
                intent.putExtra("score", score)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                context.startActivity(intent)
            } else {
                if (snake.GetSnakeBody().first.IsEqual(apple)) {
                    snake.GrowSnake()

                    var x = (0..20).random()
                    var y = (0..26).random()
                    apple = Point(x, y)

                    score += 1
                    score_view?.text = "Score : ${score}"
                }

                if (snake.GetSnakeBody().first.x < 0 || snake.GetSnakeBody().first.y < 0 || snake.GetSnakeBody().first.x > 21 || snake.GetSnakeBody().first.y > 27) {
                    game_over = true
                    val intent = Intent(context, GameOverActivity::class.java)
                    intent.putExtra("score", score)
                    context.startActivity(intent)
                } else {
                    invalidate()
                }
            }
        }
    }

    companion object {
        private const val FRAME_RATE = 250
    }
}
