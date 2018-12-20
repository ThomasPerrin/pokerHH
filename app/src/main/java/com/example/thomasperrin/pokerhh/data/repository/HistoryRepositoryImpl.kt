package com.example.thomasperrin.pokerhh.data.repository

import android.content.Context
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.*
import com.example.thomasperrin.pokerhh.BuildConfig
import com.example.thomasperrin.pokerhh.data.database.HistoryDao
import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.domain.history.HistoryRepository
import com.example.thomasperrin.pokerhh.utils.VerificationsUtils
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.internal.observers.SubscriberCompletableObserver
import io.reactivex.internal.subscribers.SubscriberResourceWrapper
import io.reactivex.schedulers.Schedulers
import java.util.Arrays.asList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryRepositoryImpl @Inject constructor(private val db: FirebaseFirestore,
                                                private val historyDao: HistoryDao,
                                                private val context: Context): HistoryRepository{

    override fun getOneHistory(id: Int): Observable<History> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addHistory(history: History): Completable {
        return Completable.create { emitter ->
            historyDao.insertHistory(history)
            db.collection(BuildConfig.FIREBASE_FIRESTORE_HISTORY)
                .add(history)
                .addOnSuccessListener {
                    emitter.onComplete()
                }
                .addOnFailureListener {
                    emitter.onError(it)
                }

        }.subscribeOn(Schedulers.io())
    }

    override fun getAllHistory(): Observable<ArrayList<History>> {

        return Observable.create{ emitter ->
            VerificationsUtils.hasInternetConnection().subscribe{hasInternet ->
                if(hasInternet){
                    db.collection(BuildConfig.FIREBASE_FIRESTORE_HISTORY).addSnapshotListener{ snapshots,e ->
                        if (e != null) {
                            emitter.onError(e)
                            return@addSnapshotListener
                        }
                        val histories: ArrayList<History> = arrayListOf()
                        snapshots?.let {
                            for (doc in snapshots) {
                                val history = doc as? History?
                                if(history != null) {
                                    histories.add(history)
                                }
                            }
                        }
                        emitter.onNext(histories)
                        emitter.onComplete()
                    }
                } else {
                    val array: ArrayList<History> = arrayListOf()
                    if(historyDao.getHistories().value != null)
                        array.addAll(historyDao.getHistories().value!!)
                    emitter.onNext(array)
                    emitter.onComplete()
                }
            }
        }
    }

    override fun getMyHistory(): Observable<ArrayList<History>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}