package com.adryanev.dicoding.hewanlangka.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Project: HewanLangka
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 19/09/19
 * Time: 19:00
 */

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, image: String?){
    if(!image.isNullOrEmpty()){
        Glide.with(view.context)
            .load(image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: CircleImageView, image: String?){
    if(!image.isNullOrEmpty()){
        Glide.with(view.context)
            .load(image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}