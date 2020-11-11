package com.github.pksokolowski.scopedarch.repository

import com.github.pksokolowski.scopedarch.model.Content
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FakeContentRepository @Inject constructor() {

    fun getContent(): Single<List<Content>> = Single.fromObservable<List<Content>> {
        Observable.fromIterable(
            listOf(
                Content(1, "abc", 1)
            )
        )
    }
}