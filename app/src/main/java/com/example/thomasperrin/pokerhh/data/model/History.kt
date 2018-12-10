package com.example.thomasperrin.pokerhh.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity
class History() : Parcelable {
     override fun writeToParcel(dest: Parcel?, flags: Int) {
          TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun describeContents(): Int {
          TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     @PrimaryKey(autoGenerate = true)
     var id: Long = 0

     var bigBlind: Int = 0
     var ante: Int = 0
     var idPlayer: Long = 0
     var isWin: Boolean = true
     var nbPlayers: Int = 0
     var type: Int = 0
     var board: String? = ""
     var keyWords: String? = ""
     var preflop: String? = ""
     var flop: String? = ""
     var turn: String? = ""
     var river: String? = ""
     var handsPlayers: String? = ""
     var myHand: String? = ""
     var createdAt: String? = ""
     var isTraining: Boolean = false
     var isPrivate: Boolean = false
     var context: String? = ""

     constructor(parcel: Parcel) : this() {
          id = parcel.readLong()
          bigBlind = parcel.readInt()
          ante = parcel.readInt()
          idPlayer = parcel.readLong()
          isWin = parcel.readByte() != 0.toByte()
          nbPlayers = parcel.readInt()
          type = parcel.readInt()
          board = parcel.readString()
          keyWords = parcel.readString()
          preflop = parcel.readString()
          flop = parcel.readString()
          turn = parcel.readString()
          river = parcel.readString()
          handsPlayers = parcel.readString()
          myHand = parcel.readString()
          createdAt = parcel.readString()
          isTraining = parcel.readByte() != 0.toByte()
          isPrivate = parcel.readByte() != 0.toByte()
          context = parcel.readString()
     }

     companion object CREATOR : Parcelable.Creator<History> {
          override fun createFromParcel(parcel: Parcel): History {
               return History(parcel)
          }

          override fun newArray(size: Int): Array<History?> {
               return arrayOfNulls(size)
          }
     }

}