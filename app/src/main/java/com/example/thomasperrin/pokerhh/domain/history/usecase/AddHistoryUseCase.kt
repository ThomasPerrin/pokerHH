package com.example.thomasperrin.pokerhh.domain.history.usecase

import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.data.repository.HistoryRepositoryImpl
import com.example.thomasperrin.pokerhh.domain.core.CompletableWithParamUseCase

class AddHistoryUseCase(private val repository: HistoryRepositoryImpl) : CompletableWithParamUseCase<History> {

    override fun execute(t: History) = repository.addHistory(t)

}