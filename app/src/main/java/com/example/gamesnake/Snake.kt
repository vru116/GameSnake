package com.example.gamesnake

import java.util.LinkedList

class Snake(begin_position: Point) {
    private var body: LinkedList<Point> = LinkedList()
    private var direction: String = "RIGHT"

    init {
        this.body.add(begin_position)
        this.body.add(begin_position)
        this.body.add(begin_position)
    }

    fun GetSnakeBody(): LinkedList<Point> {
        return this.body
    }

    fun GetSnakeDirection(): String {
        return this.direction
    }

    fun SetSnakeDirection(new_direction: String) {
        if ((this.direction == "UP" && (new_direction == "RIGHT" || new_direction == "LEFT"))
            || (this.direction == "DOWN" && (new_direction == "RIGHT" || new_direction == "LEFT"))
            || (this.direction == "RIGHT" && (new_direction == "UP" || new_direction == "DOWN"))
            || (this.direction == "LEFT" && (new_direction == "UP" || new_direction == "DOWN"))
        ) {
            this.direction = new_direction
        }
    }

    fun MoveSnake() {
        var new_head: Point = Point(this.GetSnakeBody().first.x, this.GetSnakeBody().first.y)

        when (this.direction) {
            "UP" -> {
                new_head.y -= 1
            }

            "DOWN" -> {
                new_head.y += 1
            }

            "LEFT" -> {
                new_head.x -= 1
            }

            "RIGHT" -> {
                new_head.x += 1
            }
        }
        this.body.removeLast()
        this.body.addFirst(new_head)
    }

    fun GrowSnake() {
        val tail = this.body[body.size - 1]
        this.body.addLast(Point(tail.x, tail.y))
        this.body.addLast(Point(tail.x, tail.y))
        this.body.addLast(Point(tail.x, tail.y))
        this.body.addLast(Point(tail.x, tail.y))
    }
}
