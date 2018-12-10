package com.example.thomasperrin.pokerhh.data.repository

import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.history.HistoryRepository
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryRepositoryImpl @Inject constructor(private val db: FirebaseFirestore): HistoryRepository{

    override fun getOneHistory(id: Int): Observable<History> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addHistory(hand: History): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllHistory(): Observable<List<History>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMyHistory(): Observable<List<History>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}