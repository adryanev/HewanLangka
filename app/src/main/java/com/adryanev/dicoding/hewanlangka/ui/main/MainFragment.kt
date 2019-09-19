package com.adryanev.dicoding.hewanlangka.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.adryanev.dicoding.hewanlangka.R
import com.adryanev.dicoding.hewanlangka.adapters.MainAdapter
import com.adryanev.dicoding.hewanlangka.databinding.MainFragmentBinding
import com.adryanev.dicoding.hewanlangka.utils.InjectorUtils

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels {

        InjectorUtils.provideMainViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = MainFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = MainAdapter()
        binding.apply {
            rvContactList.adapter = adapter
        }

        subscribeUi(adapter)
        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_profil -> {
                val directions = MainFragmentDirections.actionMainFragmentToProfilFragment()
                findNavController().navigate(directions)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeUi(adapter: MainAdapter){
        viewModel.hewans.observe(viewLifecycleOwner){
                hewan ->  adapter.submitList(hewan)

        }
    }


}
