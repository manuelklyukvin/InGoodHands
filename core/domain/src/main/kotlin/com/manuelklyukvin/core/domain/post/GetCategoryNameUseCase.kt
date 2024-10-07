package com.manuelklyukvin.core.domain.post

interface GetCategoryNameUseCase {

    operator fun invoke(category: String): String
}