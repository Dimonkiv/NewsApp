package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.NewsClickListener
import com.example.newsapp.data.model.News
import com.example.newsapp.databinding.ItemNewsBinding

/**
 * Created by ivankiv on 03,July,2021
 */
class NewsAdapter(
    private val items: List<News>,
    private val listener: NewsClickListener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: News) {
            with(binding) {
                titleTv.text = item.title
                subtitleTv.text = item.description
                sourceTv.text = item.source
                dateTv.text = item.date

                Glide.with(root)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(imageView)

                newsContainer.setOnClickListener {
                    listener.onNewsClick(item.id)
                }
            }
        }
    }

}