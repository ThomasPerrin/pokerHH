package com.example.thomasperrin.pokerhh.ui.newhand.flow

import android.content.Context
import com.example.thomasperrin.pokerhh.data.model.History
import com.example.thomasperrin.pokerhh.ui.BaseViewModel
import com.example.thomasperrin.pokerhh.utils.HelperHistory
import javax.inject.Inject

class HistoryFlowViewModel @Inject constructor(val context: Context): BaseViewModel<HistoryFlowInteractor>() {

    var history: History? = null

    var step: Int = 0
    var nbPlayer: Int = 0
    var priceMin: Int = 0
    var curPosInList: Int = 0

    var preflop = arrayListOf<String>()
    var flop = arrayListOf<String>()
    var turn = arrayListOf<String>()
    var river = arrayListOf<String>()

    private var hasFold: HashSet<Int> = HashSet()

    fun nextPlayer(value: String){

        when(step){
            0 -> preflop.add(value)
            1 -> flop.add(value)
            2 -> turn.add(value)
            3 -> river.add(value)
        }

        when(value){
            "fold" -> {
                if(!hasFold.contains(getCurPosInListByStep()%nbPlayer))
                    hasFold.add(getCurPosInListByStep()%nbPlayer)
                if(hasFold.size == (nbPlayer - 1)) {
                    getInteractor()!!.finish()
                    return
                }
            }
            else -> priceMin = value.replace(",",".").toInt()
        }

        curPosInList++
        while (hasFold.contains((getCurPosInListByStep()) % nbPlayer)) {
            curPosInList++
            when(step){
                0 -> preflop.add("nn")
                1 -> flop.add("nn")
                2 -> turn.add("nn")
                3 -> river.add("nn")
            }
        }

        when(step){
            0 -> if(needChangeStep(preflop)){stepUp(); return;}
            1 -> if(needChangeStep(flop)){stepUp(); return;}
            2 -> if(needChangeStep(turn)){stepUp(); return;}
            3 -> if(needChangeStep(river)){stepUp(); return;}
        }

        getInteractor()!!.nextPlay()

    }

    private fun stepUp(){
        if(step == 4){
            getInteractor()!!.finish()
            return
        }
        step++
        priceMin=0
        curPosInList=0
        while (hasFold.contains((getCurPosInListByStep()) % nbPlayer)) {
            curPosInList++
            when(step){
                0 -> preflop.add("nn")
                1 -> flop.add("nn")
                2 -> turn.add("nn")
                3 -> river.add("nn")
            }
        }
        getInteractor()!!.nextPlay()
    }

    private fun needChangeStep(listBis: ArrayList<String>):Boolean{
        var list: ArrayList<String> = arrayListOf()
        list.addAll(listBis)
        if(list.size < nbPlayer)
            return false
        val statNbBetMin = nbPlayer - hasFold.size
        var curNbBetMin = 0
        for(value in list){
            if(value == priceMin.toString())
                curNbBetMin++
        }
        return statNbBetMin == curNbBetMin
    }

    fun getPosByCurrentPosInList(position: Int, step: Int): Int{
        val realPosInList = position%nbPlayer
        var listPosName: ArrayList<Int> = arrayListOf()
        listPosName = if(step == 0){
            HelperHistory.getPlayersSuitePreFlop(nbPlayer)
        } else {
            HelperHistory.getPlayersSuitePostFlop(nbPlayer)
        }
        return listPosName[realPosInList]
    }

    fun getValueStringBoard(list: ArrayList<String>, step: Int): String{
        val listText = arrayOfNulls<String>(nbPlayer)
        var index = -1
        for(value in list){
            index++
            if(value == "0") {
                listText[index%nbPlayer] = "Check(${context.getString(getPosByCurrentPosInList(index,step))}) => "
                continue
            }
            if(value == "fold") {
                listText[index%nbPlayer] = "Fold(${context.getString(getPosByCurrentPosInList(index,step))}) => "
                continue
            }
            if(value == "nn" || value.isBlank() || value.isEmpty() || value == "null") {
                continue
            }
            listText[index%nbPlayer] = "$value(${context.getString(getPosByCurrentPosInList(index,step))}) => "
        }

        var text = ""
        for(value in listText){
            if(value != null)
                text += value
        }

        return text
    }

    fun getCurPosInListByStep(): Int{
        return if(step==0){
            curPosInList
        } else {
            curPosInList-2
        }
    }

}