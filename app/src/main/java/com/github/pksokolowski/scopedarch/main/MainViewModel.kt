package com.github.pksokolowski.scopedarch.main

import com.github.pksokolowski.scopedarch.R
import com.github.pksokolowski.scopedarch.di.ScreenScope
import com.github.pksokolowski.scopedarch.model.Content
import com.github.pksokolowski.scopedarch.utils.Status
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Consumer
import javax.inject.Inject

@ScreenScope
class MainViewModel @Inject constructor(

) {
    private val contentRelay: BehaviorRelay<List<Content>> = BehaviorRelay.create()
    private val errorRelay: BehaviorRelay<Status> = BehaviorRelay.create()
    private val loadingRelay: BehaviorRelay<Boolean> = BehaviorRelay.create()

    val content: Observable<List<Content>> = contentRelay

    val loading: Observable<Boolean> = loadingRelay

    val error: Observable<Status> = errorRelay

    val loadingUpdated: Consumer<Boolean?> = loadingRelay

    fun contentUpdated(): Consumer<List<Content>> {
        errorRelay.accept(Status.NONE)
        return contentRelay
    }

    fun onError(): Consumer<Throwable> {
        return Consumer<Throwable> {
            errorRelay.accept(Status.ERROR(R.string.error_loading_content))
        }
    }
}