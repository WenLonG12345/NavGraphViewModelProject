package com.example.navgraphviewmodelproject.navGraphViewModels

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.databinding.FragmentNavGraphViewModelsBinding


class NavGraphViewModelsFragment : Fragment(R.layout.fragment_nav_graph_view_models) {

    private lateinit var binding: FragmentNavGraphViewModelsBinding
    private val navGraphViewModel by navGraphViewModels<NavGraphViewModel>(R.id.navigation_sub_navgraph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNavGraphViewModelsBinding.bind(view)

        binding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_byNavGraphViewModelsFragment_to_navGraphViewModelsTwoFragment)
        }

        binding.etVm.doAfterTextChanged {
            navGraphViewModel.sampleText.postValue(it.toString())
        }

        navGraphViewModel.sampleText.observe(viewLifecycleOwner, {
            binding.tvVm.text = it
        })
    }
}