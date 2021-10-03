package com.example.navgraphviewmodelproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelproject.activityViewModels.ActivityViewModel
import com.example.navgraphviewmodelproject.databinding.FragmentMainBinding
import com.example.navgraphviewmodelproject.navGraphViewModels.NavGraphViewModel
import com.example.navgraphviewmodelproject.viewModels.VMViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val vmViewModel by viewModels<VMViewModel>()
    private val activityVM by activityViewModels<ActivityViewModel>()
//    private val navGraphViewModel by navGraphViewModels<NavGraphViewModel>(R.id.navigation_sub_navgraph) {
//        defaultViewModelProviderFactory
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)

        vmViewModel.sampleText.observe(viewLifecycleOwner, {
            binding.tvVm.text = it
        })

        activityVM.sampleText.observe(viewLifecycleOwner, {
            binding.tvActivityVm.text = it
        })

//        navGraphViewModel.sampleText.observe(viewLifecycleOwner, {
//            binding.tvNavgraphVm.text = it
//        })

        binding.btnByViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_byViewModelsFragment)
        }

        binding.btnByActivityViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_byActivityViewModelsFragment)
        }

        binding.btnByNavgraphViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_navigation_sub_navgraph)
        }
    }
}