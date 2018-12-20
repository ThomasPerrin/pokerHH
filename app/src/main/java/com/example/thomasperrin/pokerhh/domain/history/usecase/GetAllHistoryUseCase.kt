package com.example.thomasperrin.pokerhh.domain.history.usecase

import androidx.lifecycle.LiveData
import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.core.ObservableUseCase
import com.example.thomasperrin.pokerhh.domain.history.HistoryRepository

class GetAllHistoryUseCase(private val repository: HistoryRepository): ObservableUseCase<ArrayList<History>> {

    override fun execute() = repository.getAllHistory()

}