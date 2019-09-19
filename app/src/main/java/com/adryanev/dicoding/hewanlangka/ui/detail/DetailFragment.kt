package com.adryanev.dicoding.hewanlangka.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import com.adryanev.dicoding.hewanlangka.databinding.DetailFragmentBinding
import com.adryanev.dicoding.hewanlangka.utils.InjectorUtils

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }


    private val args: DetailFragmentArgs by navArgs()

    private val detailViewModel: DetailViewModel by viewModels {
        InjectorUtils.provideDetailViewModelFactory(requireContext(), args.id)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailFragmentBinding.inflate(inflater, container, false).apply {
            vm = detailViewModel
            lifecycleOwner = this@DetailFragment
        }

        return binding.root
    }

}
