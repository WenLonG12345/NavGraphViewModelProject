package com.example.navgraphviewmodelproject.activityViewModels

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.databinding.FragmentActivityViewModelsBinding


class ActivityViewModelsFragment : Fragment(R.layout.fragment_activity_view_models) {

    private lateinit var binding: FragmentActivityViewModelsBinding
    private val activityVM by activityViewModels<ActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentActivityViewModelsBinding.bind(view)

        binding.etVm.doAfterTextChanged {
            activityVM.sampleText.postValue(it.toString())
        }

        activityVM.sampleText.observe(viewLifecycleOwner, {
            binding.tvVm.text = it
        })
    }

}