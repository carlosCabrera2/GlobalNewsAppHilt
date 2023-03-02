package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.UIState
import com.example.globalnewsapphilt.Utilities.ViewType
import com.example.globalnewsapphilt.View.Adapter.NewsAdapter
import com.example.globalnewsapphilt.databinding.FragmentDetailItemBinding

class ArticleFragment: BaseFragment() {

    private val binding by lazy{
        FragmentDetailItemBinding.inflate(layoutInflater)
    }

    private val newsAdapter by lazy{
        NewsAdapter{}
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getArticleDetails()

        return binding.root
    }

    private fun getArticleDetails(){

        Glide
            .with(binding.root)
            .load(newsViewModel.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.baseline_image_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.ivArticleUrl)

        binding.tvContent.text = newsViewModel.description
        binding.tvTitle.text = newsViewModel.title
        binding.tvAuthor.text = newsViewModel.author
        binding.tvPublishingDate.text = newsViewModel.publishedAt
    }


}