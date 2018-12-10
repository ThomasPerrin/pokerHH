package com.example.thomasperrin.pokerhh.domain.history.usecase

import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.core.ObservableWithParamUseCase
import com.example.thomasperrin.pokerhh.domain.history.HistoryRepository

class GetOneHistoryUseCase(private val repository: HistoryRepository): ObservableWithParamUseCase<Int, History> {

    override fun execute(id: Int) = repository.getOneHistory(id)

}