package com.sugarspoon.desafioandroid.features.characters.adapters

import android.view.View
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder
import com.sugarspoon.domain.model.Result
import kotlinx.android.synthetic.main.item_character.view.*


internal class CarouselViewHolder(itemView: View) : RecyclerViewHolder<Result>(itemView) {
    internal val root = itemView
    internal val itemName = itemView.itemCharacterNameTv
    internal val itemPhoto = itemView.itemCharacterPhotoIv
}