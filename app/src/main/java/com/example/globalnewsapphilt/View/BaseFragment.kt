package com.example.globalnewsapphilt.View

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.globalnewsapphilt.ViewModel.NewsViewModel
import com.example.globalnewsapphilt.databinding.MainRecyclerViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment: Fragment() {

    protected val bindingRv: MainRecyclerViewBinding by lazy{
            MainRecyclerViewBinding.inflate(layoutInflater)
    }

    protected val newsViewModel: NewsViewModel by lazy {
        ViewModelProvider(requireActivity())[NewsViewModel::class.java]
    }

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun showError(message: String, action:()-> Unit){
        AlertDialog.Builder(requireActivity())
            .setTitle("Error Occured")
            .setMessage(message)
            .setPositiveButton(
                "RETRY"){
                        dialog, _->
                        action()
                        dialog.dismiss()
            }
            .setNegativeButton(
                "DISMISS"){
                        dialog, _ -> action()
                        dialog.dismiss()
            }
            .create()
            .show()
    }


}