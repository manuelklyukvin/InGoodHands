package com.manuelklyukvin.core.presentation.di

import android.content.Context
import com.manuelklyukvin.core.data.post.GetCategoryNameUseCaseImpl
import com.manuelklyukvin.core.domain.post.GetCategoryNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object CoreModule {

    @Provides
    fun provideGetCategoryNameUseCase(@ApplicationContext context: Context): GetCategoryNameUseCase {
        return GetCategoryNameUseCaseImpl(context)
    }
}