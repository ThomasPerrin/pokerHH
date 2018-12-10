package com.example.thomasperrin.pokerhh.domain.core

import io.reactivex.Observable

interface ObservableWithParamUseCase<E,T> {

    fun execute(e: E): Observable<T>

}