package com.github.pksokolowski.scopedarch.main

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.pksokolowski.scopedarch.base.BaseController
import com.github.pksokolowski.scopedarch.databinding.ScreenContentMainBinding
import com.github.pksokolowski.scopedarch.utils.Status
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class MainFeatureController : BaseController() {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ScreenContentMainBinding

    override fun onViewBound(view: View) {
        binding.list.layoutManager = LinearLayoutManager(view.context)
        binding.list.adapter = ContentAdapter(presenter)
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf<Disposable>(
            viewModel.loading
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { loading ->
                    binding.loadingIndicator.setVisibility(if (loading) View.VISIBLE else View.GONE)
                    binding.list.setVisibility(if (loading) View.GONE else View.VISIBLE)
                    binding.tvError.setVisibility(if (loading) View.GONE else binding.tvError.visibility)
                },
            viewModel.content
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((binding.list.adapter as ContentAdapter)::setData),
            viewModel.error
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { errorRes ->
                    when (errorRes) {
                        is Status.ERROR -> {
                            binding.tvError.setVisibility(View.VISIBLE)
                            binding.list.setVisibility(View.GONE)

                            binding.tvError.setText(errorRes.errorStringRes)
                        }
                        else -> {

                            binding.tvError.setText(null)
                            binding.tvError.setVisibility(View.GONE)
                        }
                    }
                }
        )
    }

    override fun getView(inflater: LayoutInflater): View {
        binding = ScreenContentMainBinding.inflate(inflater)
        return binding.root
    }
}