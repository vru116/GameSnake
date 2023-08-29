package com.example.gamesnake

class Point(var x: Int, var y: Int) {
    fun IsEqual(other: Point): Boolean {
        if (this.x == other.x && this.y == other.y) {
            return true
        }
        return false
    }
}