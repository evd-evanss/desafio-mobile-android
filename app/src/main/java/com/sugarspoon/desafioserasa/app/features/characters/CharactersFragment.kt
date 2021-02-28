package com.sugarspoon.desafioserasa.app.features.characters

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sugarspoon.desafioserasa.app.base.BaseFragment
import com.sugarspoon.desafioserasa.app.features.characters.adapters.CarouselAdapter
import com.sugarspoon.desafioserasa.app.features.characters.adapters.ItemsVerticalAdapter
import com.sugarspoon.desafioserasa.databinding.FragmentCharacterBinding
import com.sugarspoon.desafioserasa.utils.extensions.scrollToEnd
import com.sugarspoon.domain.model.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_character.*
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharacterBinding>(
    FragmentCharacterBinding::inflate
) {

    @Inject
    lateinit var viewModel: CharactersViewModel
    @Inject
    lateinit var factoryAdapter: CarouselAdapter
    @Inject
    lateinit var factoryVerticalAdapter: ItemsVerticalAdapter

    private val carouselAdapter by lazy { factoryAdapter.create() }
    private val comicsLargeAdapter by lazy { factoryVerticalAdapter.create() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListeners()
        setupObservers()
        initUi()
    }

    private fun initUi() = viewModel.handle(CharactersIntent.LoadData)

    private fun setupRecyclerView() = binding?.run {
        characterCarouselRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            carouselAdapter.submitList(mutableListOf())
            adapter = carouselAdapter
        }
        characterComicsRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                true
            )
            carouselAdapter.submitList(mutableListOf())
            adapter = comicsLargeAdapter
        }
    }

    private fun setupListeners() = binding?.run {
        characterRefreshSr.setOnRefreshListener {
            viewModel.handle(CharactersIntent.LoadVerticalAdapter)
        }
        characterComicsRv.viewTreeObserver.addOnGlobalLayoutListener {
            characterComicsRv.scrollToEnd()
        }
    }

    private fun setupObservers() = viewModel.state.observe(viewLifecycleOwner) { state ->
        when (state) {
            is CharactersState.LoadCarousel -> displayCarousel(items = state.items)
            is CharactersState.LoadVerticalAdapter -> displayItems(items = state.items)
            is CharactersState.Loading -> displayLoading(isLoading = state.isLoading)
            is CharactersState.Error -> displayError(message = state.message)
        }
    }

    private fun displayItems(items: List<Result>) = comicsLargeAdapter.apply {
        characterComicsRv.scheduleLayoutAnimation()
        submitList(items)
        showToast("Total: ${items.size} revistas")
    }

    private fun displayCarousel(items: List<Result>) =
        carouselAdapter.submitList(items)

    private fun displayLoading(isLoading: Boolean) = binding?.run {
        characterRefreshSr.isRefreshing = isLoading
    }

    private fun displayError(message: String) = binding?.run {
        showToast(message)
    }
}