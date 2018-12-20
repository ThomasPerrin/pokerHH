package com.example.thomasperrin.pokerhh.ui

import androidx.lifecycle.ViewModel
import com.example.thomasperrin.pokerhh.utils.Constants
import java.lang.ref.WeakReference

open class BaseViewModel<I>: ViewModel() {

    lateinit var mInteractor: WeakReference<I>

    fun getInteractor(): I? {
        return mInteractor.get()
    }

    fun setInteractor(navigator: I) {
        this.mInteractor = WeakReference(navigator)
        val ll: Int = 1_000_000
        ll.also{ ll.toString() }
    }



}