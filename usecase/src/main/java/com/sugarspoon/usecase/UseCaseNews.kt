package com.sugarspoon.usecase

import com.sugarspoon.data.BaseDataRepository
import javax.inject.Inject

class UseCaseBase @Inject constructor (
    private val repository: BaseDataRepository
){

    suspend fun getData() = repository.getData()
}