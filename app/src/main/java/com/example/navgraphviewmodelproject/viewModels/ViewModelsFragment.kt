package com.example.navgraphviewmodelproject.viewModels

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.databinding.FragmentViewModelsBinding


class ViewModelsFragment : Fragment(R.layout.fragment_view_models) {

    private lateinit var binding: FragmentViewModelsBinding
    private val vmViewModel by viewModels<VMViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentViewModelsBinding.bind(view)

        binding.etVm.doAfterTextChanged {
            vmViewModel.sampleText.postValue(it.toString())
        }

        vmViewModel.sampleText.observe(viewLifecycleOwner, {
            binding.tvVm.text = it
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ViewModelFragment", "onDestroy()")
    }

}