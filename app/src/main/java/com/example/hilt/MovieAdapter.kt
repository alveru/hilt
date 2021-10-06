package com.example.hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt.model.MovieModel

class MovieAdapter(
    val items: List<MovieModel>
): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.ivThumbnail)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val date: TextView = view.findViewById(R.id.tvDate)
        val rating: TextView = view.findViewById(R.id.tvRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.view.context)
            .load(items[position].posterPath)
            .into(holder.image)
        holder.title.text = items[position].title
        holder.date.text = items[position].releaseDate
        holder.rating.text = items[position].voteAverage.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}