package com.github.pksokolowski.scopedarch.details

import com.github.pksokolowski.scopedarch.di.ScreenScope
import javax.inject.Inject
import javax.inject.Named

@ScreenScope
class DetailsPresenter @Inject constructor(
    @Named("something") private val something: String
) {

}