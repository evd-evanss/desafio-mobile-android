package com.sugarspoon.desafioandroid.features.features.details

import androidx.lifecycle.Observer
import com.sugarspoon.desafioandroid.features.details.DetailsIntent
import com.sugarspoon.desafioandroid.features.details.DetailsState
import com.sugarspoon.desafioandroid.features.details.DetailsViewModel
import com.sugarspoon.desafioandroid.features.features.base.BaseRxTest
import com.sugarspoon.desafioandroid.features.features.utils.getOrAwaitValue
import com.sugarspoon.domain.model.mockResult
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest : BaseRxTest() {

    @Mock
    lateinit var detailsState: Observer<DetailsState>

    lateinit var viewModel: DetailsViewModel

    @Before
    fun setup() {
        viewModel = DetailsViewModel()
        viewModel.state.observeForever(detailsState)
    }

    @Test
    fun `Given that I get argument (Result), When start view, Then upload image and texts`() =
        instantExecutorRule.run {
            //Act
            viewModel.handle(DetailsIntent.InitUi(mockResult))
            //Assert
            val value = viewModel.state.getOrAwaitValue()
            assert(value == DetailsState.LoadUi(mockResult))
        }

    @Test
    fun `Given that I get argument (Result-description is empty), When start ui, Then load placeholderDescription`() =
        instantExecutorRule.run {
            //Act
            viewModel.handle(DetailsIntent.EvaluateDescription(description = ""))
            //Assert
            val value = viewModel.state.getOrAwaitValue()
            assert(value == DetailsState.LoadPlaceHolderDescription)
        }

    @Test
    fun `Given that I get argument (Result-description is not empty), When start ui, Then not load placeholderDescription`() =
        instantExecutorRule.run {
            //Act
            viewModel.handle(DetailsIntent.EvaluateDescription(description = mockResult.description))
            //Assert
            val value = viewModel.state.getOrAwaitValue() ?: null
            assert(value != DetailsState.LoadPlaceHolderDescription)
        }
}