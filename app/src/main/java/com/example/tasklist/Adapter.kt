package com.example.tasklist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var taskList: TaskList): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun getItemCount() = taskList.getValue().size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setTask(taskList.getValue()[position])
        holder.onDeleteButtonTapped = {
            taskList.remove(position)
            this.notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var deleteButton: Button
        var onDeleteButtonTapped: () -> Unit = {}
        private var task: Task? = null
        private var textView: TextView? = null
        init {
            deleteButton = itemView.findViewById(R.id.deleteButton)
            deleteButton.setOnClickListener {
                onDeleteButtonTapped()
            }
            textView = itemView.findViewById(R.id.textView)
            itemView.setOnClickListener {
                if (task?.isCompleted == true) {
                    task?.markNotCompleted()
                    itemView.setBackgroundColor(Color.TRANSPARENT)
                } else if (task?.isCompleted == false) {
                    task?.markCompleted()
                    itemView.setBackgroundColor(Color.GREEN)
                }
            }
        }

        fun setTask(task: Task) {
            this.task = task
            textView?.text = task.name
        }
    }
}