package com.example.thomasperrin.pokerhh.ui.newhand

import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.history.usecase.AddHistoryUseCase
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import javax.inject.Inject

class NewHandViewModel @Inject constructor(private val addHistoryUseCase: AddHistoryUseCase): BaseViewModel<NewHandInteractor>() {

    val history: History = History()

    fun sendHistory(){
        addHistoryUseCase.execute(history)
    }
}