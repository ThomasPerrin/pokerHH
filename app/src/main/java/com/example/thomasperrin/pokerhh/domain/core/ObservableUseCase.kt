package com.example.thomasperrin.pokerhh.domain.core

import io.reactivex.Observable


interface ObservableUseCase<T> {

    fun execute(): Observable<T>
}