package com.example.globalnewsapphilt.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globalnewsapphilt.Model.Domain.NewsDomain
import com.example.globalnewsapphilt.Utilities.UIState
import com.example.globalnewsapphilt.Utilities.ViewType
import com.example.globalnewsapphilt.View.Adapter.NewsAdapter
import com.example.globalnewsapphilt.ViewModel.NewsViewModel
import com.example.globalnewsapphilt.databinding.MainRecyclerViewBinding

class NewsFragment : BaseFragment() {

    private val binding by lazy {
        MainRecyclerViewBinding.inflate(layoutInflater)
    }

    private val newsAdapter by lazy{
        NewsAdapter{}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.rvCommonView.apply{
            layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,
            false
            )
            adapter = newsAdapter
        }

        getNews()

        return binding.root
    }


    private fun getNews(){
        newsViewModel.news.observe( viewLifecycleOwner){
            state -> val listVT : MutableList<ViewType> = mutableListOf()

            when (state){
                is UIState.LOADING ->{}
                is UIState.SUCCESS<List<NewsDomain>> ->{
                        state.response.forEach {
                            listVT.add(ViewType.NewsList(it))
                        }
                        newsAdapter.updateItems(listVT)
                }
                is UIState.ERROR -> {
                        state.error.localizedMessage?.let{
                            throw Exception("Error")
                        }

                }
            }
        }

    }
}