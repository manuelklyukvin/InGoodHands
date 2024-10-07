package com.manuelklyukvin.core.data.post

import android.content.Context
import com.manuelklyukvin.core.data.R
import com.manuelklyukvin.core.domain.post.GetCategoryNameUseCase

class GetCategoryNameUseCaseImpl(private val context: Context) : GetCategoryNameUseCase {

    override operator fun invoke(category: String) = when (category) {
        "cats" -> getString(R.string.category_cats)
        "dogs" -> getString(R.string.category_dogs)
        "birds" -> getString(R.string.category_birds)
        "fishes" -> getString(R.string.category_fishes)
        "rodents" -> getString(R.string.category_rodents)
        "reptiles" -> getString(R.string.category_reptiles)
        "exotic" -> getString(R.string.category_exotic)
        else -> getString(R.string.category_other)
    }

    private fun getString(categoryId: Int) = context.getString(categoryId)
}