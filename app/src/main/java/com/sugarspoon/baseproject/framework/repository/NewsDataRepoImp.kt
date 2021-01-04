package com.sugarspoon.baseproject.framework.repository

import com.sugarspoon.baseproject.utils.RetrofitServiceFactory
import com.sugarspoon.data.BaseDataSource
import com.sugarspoon.domain.BaseResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class BaseDataRepoImp @Inject constructor(
    retrofit: Retrofit.Builder
): BaseDataSource {

    private val service: Service = RetrofitServiceFactory(retrofit).newInstance()

    override suspend fun getData() = service.getData()
}

interface Service {

    @GET("endpoint")
    fun getData(): Flow<BaseResponse>
}