package com.example.thomasperrin.pokerhh.ui.newhand.pickcard

import androidx.lifecycle.MutableLiveData
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import javax.inject.Inject

class PickCardViewModel @Inject constructor(): BaseViewModel<PickCardInteractor>() {

    var flop1: MutableLiveData<Int> = MutableLiveData()
    var flop2: MutableLiveData<Int> = MutableLiveData()
    var flop3: MutableLiveData<Int> = MutableLiveData()
    var turn: MutableLiveData<Int> = MutableLiveData()
    var river: MutableLiveData<Int> = MutableLiveData()

    fun canValidate(): Boolean {
        if((flop1.value != null && flop1.value != R.drawable.blue_back)
            && (flop2.value != null && flop2.value != R.drawable.blue_back)
                && (flop3.value != null && flop3.value != R.drawable.blue_back)
                    && (turn.value != null && turn.value != R.drawable.blue_back)
                        && (river.value != null && river.value != R.drawable.blue_back)){
            return true
        } else if((flop1.value != null && flop1.value != R.drawable.blue_back)
                    && (flop2.value != null && flop2.value != R.drawable.blue_back)
                    && (flop3.value != null && flop3.value != R.drawable.blue_back)
                    && (turn.value != null && turn.value != R.drawable.blue_back)
                    && (river.value == null || river.value == R.drawable.blue_back)){
            return true
        } else if((flop1.value != null && flop1.value != R.drawable.blue_back)
            && (flop2.value != null && flop2.value != R.drawable.blue_back)
            && (flop3.value != null && flop3.value != R.drawable.blue_back)
            && (turn.value == null || turn.value == R.drawable.blue_back)
            && (river.value == null || river.value == R.drawable.blue_back)){
            return true
        } else if((flop1.value == null || flop1.value == R.drawable.blue_back)
            && (flop2.value == null || flop2.value == R.drawable.blue_back)
            && (flop3.value == null || flop3.value == R.drawable.blue_back)
            && (turn.value == null || turn.value == R.drawable.blue_back)
            && (river.value == null || river.value == R.drawable.blue_back)){
            return true
        }

        return false

    }

    fun setCardSelected(card: String, pos: Int): Boolean {
        val cardDrawable = HelperHistory.getImageHand(card.decapitalize())[0]
        when (pos) {
            1 -> {
                if(cardDrawable != flop2.value
                    && cardDrawable != flop3.value
                    && cardDrawable != turn.value
                    && cardDrawable != river.value) {
                    flop1.value = HelperHistory.getImageHand(card.decapitalize())[0]
                    return true
                }
            }
            2 -> {
                if(cardDrawable != flop1.value
                    && cardDrawable != flop3.value
                    && cardDrawable != turn.value
                    && cardDrawable != river.value) {
                    flop2.value = HelperHistory.getImageHand(card.decapitalize())[0]
                    return true
                }
            }
            3 -> {
                if(cardDrawable != flop2.value
                    && cardDrawable != flop1.value
                    && cardDrawable != turn.value
                    && cardDrawable != river.value) {
                    flop3.value = HelperHistory.getImageHand(card.decapitalize())[0]
                    return true
                }
            }
            4 -> {
                if(cardDrawable != flop2.value
                    && cardDrawable != flop3.value
                    && cardDrawable != flop1.value
                    && cardDrawable != river.value) {
                    turn.value = HelperHistory.getImageHand(card.decapitalize())[0]
                    return true
                }
            }
            5 -> {
                if(cardDrawable != flop2.value
                    && cardDrawable != flop3.value
                    && cardDrawable != turn.value
                    && cardDrawable != flop1.value) {
                    river.value = HelperHistory.getImageHand(card.decapitalize())[0]
                    return true
                }
            }
        }
        return false
    }

    fun setBlueCard(pos: Int) {
        when (pos) {
            1 -> flop1.value = R.drawable.blue_back
            2 -> flop2.value = R.drawable.blue_back
            3 -> flop3.value = R.drawable.blue_back
            4 -> turn.value = R.drawable.blue_back
            5 -> river.value = R.drawable.blue_back
        }
    }
}