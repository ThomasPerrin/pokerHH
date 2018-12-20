package com.example.thomasperrin.pokerhh.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.thomasperrin.pokerhh.data.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getHistories(): LiveData<List<History>>

    @Query("SELECT * FROM history WHERE id=:id")
    fun getHistory(id: Long): LiveData<History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(history: History)

    @Update
    fun updateHistory(history: History)

    @Delete
    fun deleteHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAllHistories()
}