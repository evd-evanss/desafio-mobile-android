package com.sugarspoon.data

import com.sugarspoon.domain.BaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BaseDataRepository @Inject constructor(
    private val baseDataSource: BaseDataSource
) {

    suspend fun getData() = baseDataSource.getData()
}

interface BaseDataSource {

    suspend fun getData(): Flow<BaseResponse>
}