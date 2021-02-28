package com.sugarspoon.desafioserasa.app.features.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sugarspoon.desafioserasa.R
import com.sugarspoon.desafioserasa.app.base.BaseFragment
import com.sugarspoon.desafioserasa.databinding.FragmentDetailBinding
import com.sugarspoon.domain.model.Result
import com.sugarspoon.domain.model.toPath
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {

    @Inject
    lateinit var viewModel: DetailsViewModel

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        initUi()
    }

    private fun setupObservers() = viewModel.state.observe(viewLifecycleOwner) { state ->
        when(state) {
            is DetailsState.LoadUi -> loadUi(state.result)
            is DetailsState.LoadPlaceHolderDescription -> loadPlaceHolderDescription()
        }
    }

    private fun initUi() = viewModel.handle(DetailsIntent.InitUi(character = args.character))

    private fun loadUi(result: Result) = binding?.run {
        detailHqTv.text = result.name
        detailHqDescriptionTv.text = result.description
        viewModel.handle(DetailsIntent.EvaluateDescription(description = result.description))
        Glide.with(requireContext())
            .load(result.thumbnail.toPath())
            .into(detailHqImageIv)
    }

    private fun loadPlaceHolderDescription() = binding?.run {
        detailHqDescriptionTv.text = getString(R.string.details_description_unavailable)
    }
}