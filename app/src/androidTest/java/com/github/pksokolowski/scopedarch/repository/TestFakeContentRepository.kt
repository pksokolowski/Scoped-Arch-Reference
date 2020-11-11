package com.github.pksokolowski.scopedarch.repository

import com.github.pksokolowski.scopedarch.model.Content
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TestFakeContentRepository @Inject constructor() : IFakeContentRepository {

    override fun getContent() = Single.fromObservable(
        fakeResource { listOf(Content(1, "abc", 1)) }
    )
}