package com.sugarspoon.baseproject.framework.di

import com.sugarspoon.baseproject.framework.repository.BaseDataRepoImp
import com.sugarspoon.data.BaseDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class BaseModule {

    @Singleton
    @Binds
    abstract fun bindBaseDataSource(baseDataRepository: BaseDataRepoImp): BaseDataSource
}