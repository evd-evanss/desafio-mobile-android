package com.sugarspoon.desafioandroid.features.characters.adapters

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sugarspoon.desafioandroid.R
import com.sugarspoon.domain.model.Result
import com.sugarspoon.domain.model.toPath
import dagger.hilt.android.scopes.ActivityScoped
import me.ibrahimyilmaz.kiel.adapterOf
import javax.inject.Inject

@ActivityScoped
class VerticalAdapter @Inject constructor(
    val context: Context
) {

    var onItemAdapterClicked: ((Result) -> Unit)? = null

    fun create() = adapterOf<Result> {
        register(
            layoutResource = R.layout.item_characters_large,
            viewHolder = ::VerticalViewHolder,
            onBindViewHolder = { holder, _, character ->
                holder.run {
                    itemName.text = character.name
                    Glide.with(context)
                        .load(character.thumbnail.toPath())
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .into(itemPhoto)
                    root.setOnClickListener {
                        onItemAdapterClicked?.invoke(character)
                    }
                }
            }
        )
    }
}