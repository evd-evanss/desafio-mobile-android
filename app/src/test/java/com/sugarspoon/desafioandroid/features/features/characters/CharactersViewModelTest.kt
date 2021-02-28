package com.sugarspoon.desafioandroid.features.features.characters

import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sugarspoon.data.usecase.UseCaseCharacters
import com.sugarspoon.desafioandroid.features.characters.CharactersIntent
import com.sugarspoon.desafioandroid.features.characters.CharactersState
import com.sugarspoon.desafioandroid.features.characters.CharactersViewModel
import com.sugarspoon.desafioandroid.features.features.base.BaseRxTest
import com.sugarspoon.domain.model.mockResult
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest : BaseRxTest() {

    @Mock
    lateinit var useCaseCharacters: UseCaseCharacters

    @Mock
    private lateinit var stateObserver: Observer<CharactersState>

    lateinit var charactersViewModel: CharactersViewModel

    @Before
    fun setup() {
        charactersViewModel = CharactersViewModel(useCaseCharacters = useCaseCharacters)
        charactersViewModel.state.observeForever(stateObserver)
    }

    @Test
    fun `GIVEN that as Carousel, WHEN start screen, THEN load the list and handle loading`() {
        //Arrange
        whenever(useCaseCharacters.getCharacters(0, 5)).thenReturn(
            Single.just(listOf(mockResult))
        )

        //Act
        charactersViewModel.handle(CharactersIntent.LoadData)

        //Assert
        stateObserver.run {
            verify(this).onChanged(CharactersState.Loading(true))
            verify(this).onChanged(CharactersState.Loading(false))
            verify(this).onChanged(CharactersState.LoadCarousel(listOf(mockResult)))
        }
    }
}