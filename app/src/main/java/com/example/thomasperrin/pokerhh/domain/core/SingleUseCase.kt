package com.example.thomasperrin.pokerhh.domain.core

import io.reactivex.Single


interface SingleUseCase<T> {

    fun execute(): Single<T>
}