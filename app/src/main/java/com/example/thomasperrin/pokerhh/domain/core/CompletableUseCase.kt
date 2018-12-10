package com.example.thomasperrin.pokerhh.domain.core

import io.reactivex.Completable


interface CompletableUseCase {

    fun execute(): Completable
}