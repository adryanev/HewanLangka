package com.adryanev.dicoding.hewanlangka.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adryanev.dicoding.hewanlangka.R
import com.adryanev.dicoding.hewanlangka.data.entities.Hewan
import com.adryanev.dicoding.hewanlangka.databinding.MainHewanListBinding
import com.adryanev.dicoding.hewanlangka.ui.main.MainFragmentDirections

/**
 * Project: HewanLangka
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 19/09/19
 * Time: 18:36
 */
class MainAdapter : ListAdapter<Hewan, MainAdapter.HewanViewHolder>(HewanDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.HewanViewHolder {
        return HewanViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.main_hewan_list,parent,false))
    }

    override fun onBindViewHolder(holder: MainAdapter.HewanViewHolder, position: Int) {
        getItem(position).let { hewan -> with(holder){
            bind(createOnClickListener(hewan.id),hewan)
        } }
    }

    private fun createOnClickListener(hewanId: Int?): View.OnClickListener{
        return View.OnClickListener {
            val direction = MainFragmentDirections.actionMainFragmentToDetailFragment(hewanId?:0)
            it.findNavController().navigate(direction)
        }
    }

    class HewanViewHolder(private val binding: MainHewanListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(listener : View.OnClickListener, item: Hewan){
            binding.apply {
                clickListener = listener
                hewan = item
                executePendingBindings()

            }
        }
    }

    class HewanDiffCallback: DiffUtil.ItemCallback<Hewan>(){
        override fun areItemsTheSame(oldItem: Hewan, newItem: Hewan): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hewan, newItem: Hewan): Boolean {
            return oldItem == newItem
        }

    }

}