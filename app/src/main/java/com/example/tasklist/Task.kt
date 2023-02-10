package com.example.tasklist

class Task(val name: String, var isCompleted: Boolean) {
    fun markCompleted() {
        isCompleted = true
    }

    fun markNotCompleted() {
        isCompleted = false
    }
}