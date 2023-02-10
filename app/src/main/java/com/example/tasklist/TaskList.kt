package com.example.tasklist

class TaskList {
    private var value: MutableList<Task> = mutableListOf()
    fun addTask(task: Task) {
        value.add(task)
    }
    fun getValue(): MutableList<Task> {
        return value
    }

    fun remove(index: Int) {
        value.removeAt(index)
    }
}

