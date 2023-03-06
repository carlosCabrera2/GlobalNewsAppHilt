package com.example.globalnewsapphilt.View.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globalnewsapphilt.Model.Article
import com.example.globalnewsapphilt.Model.Domain.NewsDomain
import com.example.globalnewsapphilt.Model.NewsResponse
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.databinding.FragmentMainItemBinding

class NewsAdapter(
    private val itemSet: MutableList<Article> = mutableListOf(),
    private val onItemClick: (Article)-> Unit
): RecyclerView.Adapter<NewsViewHolder>() {

    fun updateItems(newItems: List<Article>){
            if (itemSet != newItems){
                itemSet.clear()
                itemSet.addAll(newItems)
                notifyDataSetChanged()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //return if(viewType == 0){
            return    NewsViewHolder(
                    FragmentMainItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.bind(itemSet[position], onItemClick)
    }

//    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
//        holder.bind(itemSet[position], onItemClick)
    override fun getItemCount(): Int = itemSet.size
}



class NewsViewHolder(
    private val binding: FragmentMainItemBinding
        ):RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article, onItemClick: (Article) -> Unit) {

            binding.tvTitle.text = item.title
            binding.tvAuthor.text = item.author
            binding.tvPublishingDate.text = item.publishedAt


            Glide
                .with(binding.root)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.baseline_image_24)
                .error(R.drawable.baseline_broken_image_24)
                .into(binding.ivArticleUrl)

            itemView.setOnClickListener{
                Log.d("TAG", "bind: ${item.title}")
                    onItemClick(item)
            }

        }
}