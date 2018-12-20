package com.example.thomasperrin.pokerhh.ui.allhands

import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.history.usecase.AddHistoryUseCase
import com.example.thomasperrin.pokerhh.domain.history.usecase.GetAllHistoryUseCase
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class AllHandsViewModel @Inject constructor(private val getAllHistoryUseCase: GetAllHistoryUseCase): BaseViewModel<AllHandsInteractor>() {

    val histories: ArrayList<History> = arrayListOf()
    val hasChanged: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getAllHands(){
        getInteractor()!!.loading()
        val handler = Handler()
        handler.postDelayed({ // SIMULATION GET SERVE LONG
            getAllHistoryUseCase
                .execute()
                .flatMap {
                    it.add(History())
                    ObservableSource<ArrayList<History>> { it }
                }
                .subscribe(
                {
                    histories.addAll(it)
                    if(hasChanged.value == null)
                        hasChanged.value = false
                    hasChanged.value = !hasChanged.value!!
                    Log.e("getAllHistoryUseCase", "success")
                },
                {
                    Log.e("getAllHistoryUseCase", "${it.message}")
                }
            )
        }, 1000)
    }
}