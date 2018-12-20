package com.example.thomasperrin.pokerhh.domain.history

import androidx.lifecycle.LiveData
import com.example.thomasperrin.pokerhh.data.model.History
import io.reactivex.Completable
import io.reactivex.Observable

interface HistoryRepository {

    fun getOneHistory(id: Int): Observable<History>

    fun addHistory(hand: History): Completable

    fun getAllHistory(): Observable<ArrayList<History>>

    fun getMyHistory(): Observable<ArrayList<History>>

}