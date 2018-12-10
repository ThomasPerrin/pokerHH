package com.example.thomasperrin.pokerhh.ui.newhand.pickcard

import androidx.lifecycle.MutableLiveData
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import com.example.thomasperrin.pokerhh.utils.Constants
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import javax.inject.Inject

class PickCardViewModel @Inject constructor(): BaseViewModel<PickCardInteractor>() {

    var cardsDisplaying: ArrayList<Int> = arrayListOf()
    var cardDisplaying: Int = -1

    var cards: ArrayList<String> = arrayListOf()
    var canValidate: MutableLiveData<Boolean>? = MutableLiveData()

    fun canValidate(){
        canValidate!!.postValue(cards.size in 3..5 || cards.size == 0)
    }

    fun validate(){
        if(canValidate!!.value!!)
            getInteractor()!!.validate()
    }

    fun getHistoryBoard(): String{
        var board = ""
        for(card in cards){
            board += card
        }
        return board
    }

    fun setColorSelected(id: Int){
        when(id){
            R.id.spade -> cardsDisplaying = Constants.getSpadeCards()
            R.id.heart -> cardsDisplaying = Constants.getHeartCard()
            R.id.clover -> cardsDisplaying = Constants.getCloverCards()
            R.id.diamond -> cardsDisplaying = Constants.getDiamondCards()
        }
        getInteractor()!!.onColorSelected()
    }

    fun setCardSelected(id: Int){
        cardDisplaying = id
        cards.add(HelperHistory.getStringHands(id))
        getInteractor()!!.onCardSelected()
        canValidate()
    }

    fun previousClick(){
        cards.removeAt(cards.size-1)
        getInteractor()!!.onCardRemove()
    }

}