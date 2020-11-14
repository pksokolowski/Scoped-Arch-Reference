package com.github.pksokolowski.scopedarch.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.github.pksokolowski.scopedarch.base.BaseController
import com.github.pksokolowski.scopedarch.databinding.ScreenDetailsBinding

class DetailsController : BaseController {

    constructor() : super()
    constructor(bundle: Bundle) : super(bundle)

    private lateinit var binding: ScreenDetailsBinding

    override fun getView(inflater: LayoutInflater): View {
        binding = ScreenDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewBound(view: View) {

    }

    companion object {
        const val KEY_SOMETHING = "something"

        fun newInstance(something: String): DetailsController {
            val bundle = Bundle().apply {
                putString(KEY_SOMETHING, something)
            }
            return DetailsController(bundle)
        }
    }
}