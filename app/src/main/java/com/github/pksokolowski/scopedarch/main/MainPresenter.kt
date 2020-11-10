package com.github.pksokolowski.scopedarch.main

import com.github.pksokolowski.scopedarch.di.ScreenScope
import com.github.pksokolowski.scopedarch.model.Content
import com.github.pksokolowski.scopedarch.repository.FakeContentRepository
import javax.inject.Inject

@ScreenScope
class MainPresenter @Inject constructor(
    private val viewModel: MainViewModel,
    private val contentRepository: FakeContentRepository
): ContentAdapter.ItemClickedListener {
    init {
        loadContent()
    }

    private fun loadContent() {
        contentRepository.getContent()
            .doOnSubscribe { viewModel.loadingUpdated.accept(true) }
            .doOnEvent { _, _ -> viewModel.loadingUpdated.accept(false) }
            .subscribe(viewModel.contentUpdated(), viewModel.onError())
    }

    override fun onItemClicked(content: Content) {

    }

}