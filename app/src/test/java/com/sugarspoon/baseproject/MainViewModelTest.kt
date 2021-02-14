package com.sugarspoon.baseproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.sugarspoon.baseproject.app.ui.main.MainViewIntent
import com.sugarspoon.baseproject.app.ui.main.MainViewModel
import com.sugarspoon.baseproject.app.ui.main.MainViewState
import com.sugarspoon.baseproject.utils.extensions.onCollect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {


    @ExperimentalCoroutinesApi
    val testDispatcher = MainCoroutineRule(TestCoroutineDispatcher())

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        mainViewModel = MainViewModel()
    }

    @ExperimentalCoroutinesApi
    @Test
    internal fun `Given I have a button, WHEN I click on it, Then then loading should start for 1 second and stop`() = testDispatcher.runBlockingTest {

        //Test
        mainViewModel.handle(MainViewIntent.ClickButton)

        //Verify
        mainViewModel.state.collect {
            verify(it.loading == true)
        }
    }
}