package com.example.thomasperrin.pokerhh.ui.newhand

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.history.usecase.AddHistoryUseCase
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import io.reactivex.android.schedulers.AndroidSchedulers
import java.io.File
import javax.inject.Inject

class NewHandViewModel @Inject constructor(private val addHistoryUseCase: AddHistoryUseCase): BaseViewModel<NewHandInteractor>() {

    val history: History = History()

    val board: MutableLiveData<String> = MutableLiveData()
    val canGoAction: MutableLiveData<Boolean> = MutableLiveData()

    fun setValues(value: String, type: String){
        when(type){
            "bb" -> {
                canGoAction.value = false
                if(HelperHistory.isBBFormat(value)) {
                    history.bigBlind = value
                    if (history.nbPlayers!! > 1)
                        canGoAction.value = true
                }
            }
            "ante" -> {
                if(!value.isEmpty())
                    history.ante = value.toIntOrNull()
            }
            "description" -> {
                history.context = value
            }
            "type" -> {
                if(!value.isEmpty())
                    history.type = value.toIntOrNull()
            }
            "keywords" -> {
                history.keyWords = value
            }
            "nbPlayers" -> {
                history.nbPlayers = value.toIntOrNull()
                canGoAction.value = history.bigBlind != null && !history.bigBlind!!.isEmpty()
            }
        }
    }

    @SuppressLint("CheckResult")
    fun registerHH(){
        addHistoryUseCase.execute(history).subscribe(
            {
                getInteractor()!!.validate()
            },
            {
                Log.e("Error subscribe message", it.message)
            }
        )
    }

}