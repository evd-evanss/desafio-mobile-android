package com.sugarspoon.desafioserasa.app.features.characters.adapters

import android.content.Context
import com.bumptech.glide.Glide
import com.sugarspoon.desafioserasa.R
import com.sugarspoon.domain.model.Result
import com.sugarspoon.domain.model.toPath
import dagger.hilt.android.scopes.ActivityScoped
import me.ibrahimyilmaz.kiel.adapterOf
import javax.inject.Inject

@ActivityScoped
class CarouselAdapter @Inject constructor(
    val context: Context
) {

    var onItemAdapterClicked: ((Result) -> Unit)? = null

    fun create() = adapterOf<Result> {
        register(
            layoutResource = R.layout.item_character,
            viewHolder = ::CarouselViewHolder,
            onBindViewHolder = { holder, _, character ->
                holder.run {
                    itemName.text = character.name
                    Glide.with(context)
                        .load(character.thumbnail.toPath())
                        .into(itemPhoto)
                    root.setOnClickListener {
                        onItemAdapterClicked?.invoke(character)
                    }
                }
            }
        )
    }
}