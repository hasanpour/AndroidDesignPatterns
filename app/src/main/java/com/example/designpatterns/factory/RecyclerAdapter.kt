package com.example.designpatterns.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designpatterns.R

class RecyclerAdapter (private val packages: List<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val packageItem: TextView = itemView.findViewById(R.id.textViewPackageItem)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val packageView = inflater.inflate(R.layout.recyclerview_item_row, parent, false)
        // Return a new holder instance
        return ViewHolder(packageView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val packageName = packages[position]
        // Set item views based on your views and data model
        val textView = holder.packageItem
        textView.text = packageName
    }

    override fun getItemCount(): Int {
        return packages.size
    }
}