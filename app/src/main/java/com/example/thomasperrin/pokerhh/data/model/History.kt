package com.example.thomasperrin.pokerhh.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity
data class History(
     @PrimaryKey(autoGenerate = true) var id: Long = 0,
     var bigBlind: String? = "",
     var ante: Int? = 0,
     var idPlayer: Long? = 0,
     var nbPlayers: Int? = 0,
     var type: Int? = 0,
     var board: String? = "",
     var keyWords: String? = "",
     var preflop: String? = "",
     var flop: String? = "",
     var turn: String? = "",
     var river: String? = "",
     var handsPlayers: String? = "",
     var myHand: String? = "",
     var createdAt: String? = "",
     var isTraining: Boolean? = false,
     var isPrivate: Boolean? = false,
     var context: String? = ""
){

     constructor(neutre: String) : this() {}
}