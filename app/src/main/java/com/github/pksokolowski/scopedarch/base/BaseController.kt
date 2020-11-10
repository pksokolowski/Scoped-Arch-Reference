package com.github.pksokolowski.scopedarch.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.github.pksokolowski.scopedarch.di.inject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseController : Controller() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private var injected: Boolean = false


    override fun onContextAvailable(context: Context) {
        // prevents injecting the same thing multiple times, would not hurt, but wasteful
        if (!injected) {
            inject(this)
            injected = true
        }
        super.onContextAvailable(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        val view = getView(inflater)
        onViewBound(view)
        disposables.addAll(*subscriptions())
        return view
    }

    abstract fun getView(inflater: LayoutInflater): View

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        disposables.clear()
    }
//
//    protected open fun onViewBound(view: View?) {}

    protected open fun subscriptions(): Array<Disposable> {
        return arrayOf()
    }

    protected abstract fun onViewBound(view: View)
}