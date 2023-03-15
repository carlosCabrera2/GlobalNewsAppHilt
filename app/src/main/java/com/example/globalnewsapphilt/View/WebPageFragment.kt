package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.globalnewsapphilt.Model.NewsModel.Article
import com.example.globalnewsapphilt.databinding.WebViewBinding
import android.webkit.WebViewClient

class WebPageFragment: BaseFragment() {

    private val binding by lazy{
        WebViewBinding.inflate(layoutInflater)
    }

    private var selectedArticle = Article()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        selectedArticle = newsViewModel.selectedArticle
        getWebPage()
        return binding.root
    }

    private fun getWebPage() {
        binding.webPage.webViewClient = WebViewClient()
        binding.webPage.loadUrl(selectedArticle.url.toString())
//      binding.webPage.settings.javaScriptEnabled = true
        binding.webPage.settings.setSupportZoom(true)
    }


}