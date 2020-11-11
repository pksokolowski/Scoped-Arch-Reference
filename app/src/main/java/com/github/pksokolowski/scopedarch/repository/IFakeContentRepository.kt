package com.github.pksokolowski.scopedarch.repository

import com.github.pksokolowski.scopedarch.model.Content
import io.reactivex.rxjava3.core.Single

interface IFakeContentRepository{
    fun getContent(): Single<List<Content>>
}