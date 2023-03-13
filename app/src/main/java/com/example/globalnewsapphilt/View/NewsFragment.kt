package com.example.globalnewsapphilt.View

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globalnewsapphilt.R
import com.example.globalnewsapphilt.Utilities.UIState
import com.example.globalnewsapphilt.View.Adapter.NewsAdapter
import com.example.globalnewsapphilt.databinding.MainRecyclerViewBinding

class NewsFragment : BaseFragment(), SearchView.OnQueryTextListener {

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
    ): View {

        binding.svSearch.setOnQueryTextListener(this)

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

    private fun searchByCountry(query: String){
        newsViewModel.getNews(query)
        hideKeyboard()
    }

    private fun hideKeyboard(){
        val keyboard= activity?.getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        keyboard.hideSoftInputFromWindow(binding.svSearch.windowToken, 0)
    }

   override fun onQueryTextSubmit(query: String?): Boolean{
        if (!query.isNullOrEmpty()){
            searchByCountry(query)
            Toast.makeText(requireContext(),
                "$query", Toast.LENGTH_LONG).show()
        }
        return true
    }

    override fun onQueryTextChange(newSearch: String?): Boolean = true

 }






























