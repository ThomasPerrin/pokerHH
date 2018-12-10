package com.example.thomasperrin.pokerhh.domain.history.usecase

import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.core.ObservableUseCase
import com.example.thomasperrin.pokerhh.domain.history.HistoryRepository

class GetMyHistoryUseCase(private val repository: HistoryRepository): ObservableUseCase<List<History>> {

    override fun execute() = repository.getMyHistory()

}