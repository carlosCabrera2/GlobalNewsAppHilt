package com.example.globalnewsapphilt.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globalnewsapphilt.Model.Domain.NewsDomain
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.ViewType
import com.example.globalnewsapphilt.databinding.FragmentDetailItemBinding
import com.example.globalnewsapphilt.databinding.FragmentMainItemBinding

class NewsAdapter(
    private val itemSet: MutableList<ViewType> = mutableListOf(),
    private val onItemClick: (NewsDomain)-> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateItems(newItems: MutableList<ViewType>){
            if (itemSet != newItems){
                itemSet.clear()
                itemSet.addAll(newItems)
                notifyDataSetChanged()
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == 0){
                NewsViewHolder(
                    FragmentMainItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

        }else{
                DetailsViewHolder(
                    FragmentDetailItemBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                    )
                )
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (val item = itemSet[position]){
            is ViewType.NewsList -> (holder as NewsViewHolder).bind(
                item.newsList,
                onItemClick
            )
            is ViewType.ArticlesList -> (holder as DetailsViewHolder).bind(
                item.articleList
            )
        }
    }

    override fun getItemCount(): Int = itemSet.size
}

class DetailsViewHolder(
    private val binding: FragmentDetailItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(item: NewsDomain){

                binding.tvTitle.text = item.title
                binding.tvAuthor.text = item.author
                binding.tvPublishingDate.text = item.publishedAt
                binding.tvSource.text = item.source
                binding.tvDescription.text = item.description
                binding.tvContent.text = item.content


                Glide
                    .with(binding.root)
                    .load(item.urlToImage)
                    .centerCrop()
                    .placeholder(R.drawable.baseline_image_24)
                    .error(R.drawable.baseline_broken_image_24)
                    .into(binding.ivArticleUrl)
            }
}


class NewsViewHolder(
    private val binding: FragmentMainItemBinding
        ):RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NewsDomain, onItemClick: (NewsDomain) -> Unit) {

            binding.tvTitle.text = item.title
            binding.tvAuthor.text = item.author
            binding.tvPublishingDate.text = item.publishedAt
            binding.tvContent.text = item.content

            Glide
                .with(binding.root)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.baseline_image_24)
                .error(R.drawable.baseline_broken_image_24)
                .into(binding.ivArticleUrl)

            itemView.setOnClickListener{
                    onItemClick(item)
            }

        }
}