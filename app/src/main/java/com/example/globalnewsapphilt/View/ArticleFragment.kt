package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.example.globalnewsapphilt.R

import com.example.globalnewsapphilt.databinding.FragmentDetailItemBinding

class ArticleFragment : BaseFragment() {

    private val binding by lazy {
        FragmentDetailItemBinding.inflate(layoutInflater)
    }

    var selectedArticle = Article()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        selectedArticle = newsViewModel.selectedArticle
        getArticleDetails()
        return binding.root
    }


    private fun getArticleDetails() {

        Glide
            .with(binding.root)
            .load(selectedArticle.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.baseline_image_24)
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.ivArticleUrl)

        binding.tvContent.text = selectedArticle.description
        binding.tvTitle.text = selectedArticle.title
        binding.tvAuthor.text = selectedArticle.author

        binding.tvPublishingDate.text = selectedArticle.publishedAt

    }

}


