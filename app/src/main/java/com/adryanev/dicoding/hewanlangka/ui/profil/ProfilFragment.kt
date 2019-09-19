package com.adryanev.dicoding.hewanlangka.ui.profil

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.adryanev.dicoding.hewanlangka.R
import com.adryanev.dicoding.hewanlangka.databinding.ProfilFragmentBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class ProfilFragment : Fragment() {

    companion object {
        fun newInstance() = ProfilFragment()
    }

    private lateinit var viewModel: ProfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ProfilFragmentBinding.inflate(inflater, container, false)

        Glide.with(context!!)
            .load("https://www.dicoding.com/images/small/avatar/20190828003743d3ab2f0ba6936b967b1ba42ef9d8e9ed.jpg")
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.profilImage)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
