package com.github.pksokolowski.scopedarch.utils

import androidx.annotation.StringRes

sealed class Status {
    object NONE : Status()
    object SUCCESS : Status()
    class ERROR(@StringRes val errorStringRes: Int) : Status()
}