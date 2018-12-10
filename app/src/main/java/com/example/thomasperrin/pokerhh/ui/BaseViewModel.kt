package com.example.thomasperrin.pokerhh.ui

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<I>: ViewModel() {

    lateinit var mInteractor: WeakReference<I>

    fun getInteractor(): I? {
        return mInteractor.get()
    }

    fun setInteractor(navigator: I) {
        this.mInteractor = WeakReference(navigator)
    }

}