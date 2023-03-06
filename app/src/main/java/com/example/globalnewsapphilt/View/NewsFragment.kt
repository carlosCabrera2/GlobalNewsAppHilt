package com.example.globalnewsapphilt.View

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globalnewsapphilt.Model.Article
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.UIState
import com.example.globalnewsapphilt.View.Adapter.NewsAdapter
import com.example.globalnewsapphilt.databinding.MainRecyclerViewBinding

class NewsFragment : BaseFragment() {

    private val binding by lazy {
        MainRecyclerViewBinding.inflate(layoutInflater)
    }

    private val newsAdapter by lazy {
        NewsAdapter {
            Log.d(TAG, "Article: $it: ")
            newsViewModel.selectedArticle = it
            findNavController().navigate(R.id.action_menu_home_to_menu_detail)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.rvCommonView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            getNews()
            adapter = newsAdapter
        }


        newsViewModel.getNews()

        return binding.root
    }


    private fun getNews() {
        newsViewModel.news.observe(viewLifecycleOwner) {

            Log.d(TAG, "getNews: $it")
            println("Here $it")
            when (it) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS -> {
                    Log.d(TAG, "getNews: isSuccessful  ${it.response}")
                  it.response.articles?.let {
//                      callDetail(it)

                      newsAdapter.updateItems(it)
                  }
                }
                is UIState.ERROR -> {
                    Log.d(TAG, "getNews: Error  ")
                    AlertDialog.Builder(requireActivity())
                        .setTitle("Error occurred")
                        .setMessage(it.error.localizedMessage)
                        .setNegativeButton("DISMISS") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                }

            }
        }
    }

    fun callDetail(articles: List<Article>) {
//            Log.d(TAG, "getNews: isSuccessful  ${it.response}")
            articles.let { it ->
                binding.rvCommonView.adapter = NewsAdapter(articles as MutableList<Article>) {
                    newsViewModel.setArticle(it)
                }

            }
        }
    }
