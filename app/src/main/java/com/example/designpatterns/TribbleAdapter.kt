package com.example.designpatterns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Adapter Pattern
class TribbleAdapter(private val tribbles: List<Tribble>) : RecyclerView.Adapter<TribbleAdapter.TribbleViewHolder>() {

    inner class TribbleViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        fun bind(tribble: Tribble) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TribbleViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.row_tribble, viewGroup, false)
        return TribbleViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TribbleViewHolder, itemIndex: Int) {
        viewHolder.bind(tribbles[itemIndex])
    }

    override fun getItemCount() = tribbles.size
}

class Tribble {

}
