package com.example.thomasperrin.pokerhh.domain.history

import com.example.thomasperrin.pokerhh.data.model.History
import io.reactivex.Completable
import io.reactivex.Observable

interface HistoryRepository {

    fun getOneHistory(id: Int): Observable<History>

    fun addHistory(hand: History): Completable

    fun getAllHistory(): Observable<List<History>>

    fun getMyHistory(): Observable<List<History>>

}