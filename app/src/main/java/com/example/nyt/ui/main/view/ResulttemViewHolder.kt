package com.example.nyt.ui.main.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nyt.R

class ResulttemViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    val textViewTitle: TextView = root.findViewById(R.id.text_view_title)
    val textViewDate: TextView = root.findViewById(R.id.text_view_timestamp)
    val textViewSource: TextView = root.findViewById(R.id.textView_source)

    fun bind(title: String, date: String?, source: String) {
        textViewTitle.text = title
        textViewDate.text = date
        textViewSource.text = source
    }
}