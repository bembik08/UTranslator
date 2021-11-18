package com.test_app.descriptionfeature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test_app.model.AppState
import com.test_app.model.data.TranslationDataItem
import com.test_app.core.baseui.BaseFragment
import com.test_app.descriptionfeature.databinding.DescriptionFragmentBinding
import com.test_app.descriptionfeature.viewmodel.DescriptionViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class DescriptionFragment : BaseFragment() {
    private val viewBinding: DescriptionFragmentBinding by viewBinding(CreateMethod.INFLATE)
    private val word by lazy {
        arguments?.getString(ARG_STRING)
    }

    override val viewModel : DescriptionViewModel by viewModel(named<DescriptionViewModel>())

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessDescription -> {
                initData(appState.data)
            }
        }
    }

    private fun initData(data: TranslationDataItem)= with(viewBinding) {
        title.text = data.text
        transcription.text = data.meanings.joinToString {
            it.transcription
        }
        translationText.text = data.meanings.joinToString {
            it.translation.text
        }
        translationNote.text = data.meanings.joinToString {
            it.translation.note
        }
        imageLoader.load("https:${data.meanings.first().imageUrl}", imgWord)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
        word?.let { viewModel.getData(it) }
    }


    companion object {
        private const val ARG_STRING = "arg_string"
        fun newInstance(word: String) = DescriptionFragment().apply {
            arguments = bundleOf(ARG_STRING to word)
        }
    }
}