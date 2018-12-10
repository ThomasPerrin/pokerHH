package com.example.thomasperrin.pokerhh.utils

import android.util.Log
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.data.model.History

class HelperHistory {

    companion object {

        fun formatedHistoryMiseToArray(mises: String): List<String>{
            val valuesString = mises.split("|")
            return valuesString.map { it }
        }

        fun formatedHistoryBoardToArray(history: History): List<String>{
            val valuesString = history.board!!.split("|")
            return valuesString.map { it }
        }

        fun formatedHistoryKeywordToArray(keywords: String): List<String>{
            val valuesString = keywords.split("|")
            return valuesString.map { it }
        }

        fun formatedHistoryFromArray(array: ArrayList<String>): String{
            var valuesString = ""
            for(value in array){
                valuesString += "$value|"
            }
            return valuesString
        }

        fun formatedHistoryHandsToArray(hands: String): List<String>{
            return hands.split("|")
        }

        // GET ONE HAND CARD => return two card
        fun getImageHand(hand: String): ArrayList<Int>{
            val tabHand = hand.split("|")
            var response: ArrayList<Int> = arrayListOf()
            for (card in tabHand){
                when(card){
                    "s2" -> response.add(R.drawable.s2)
                    "s3" -> response.add(R.drawable.s3)
                    "s4" -> response.add(R.drawable.s4)
                    "s5" -> response.add(R.drawable.s5)
                    "s6" -> response.add(R.drawable.s6)
                    "s7" -> response.add(R.drawable.s7)
                    "s8" -> response.add(R.drawable.s8)
                    "s9" -> response.add(R.drawable.s9)
                    "s10" -> response.add(R.drawable.s10)
                    "sj" -> response.add(R.drawable.sj)
                    "sq" -> response.add(R.drawable.sq)
                    "sk" -> response.add(R.drawable.sk)
                    "sa" -> response.add(R.drawable.sa)
                    "h2" -> response.add(R.drawable.h2)
                    "h3" -> response.add(R.drawable.h3)
                    "h4" -> response.add(R.drawable.h4)
                    "h5" -> response.add(R.drawable.h5)
                    "h6" -> response.add(R.drawable.h6)
                    "h7" -> response.add(R.drawable.h7)
                    "h8" -> response.add(R.drawable.h8)
                    "h9" -> response.add(R.drawable.h9)
                    "h10" -> response.add(R.drawable.h10)
                    "hj" -> response.add(R.drawable.hj)
                    "hq" -> response.add(R.drawable.hq)
                    "hk" -> response.add(R.drawable.hk)
                    "ha" -> response.add(R.drawable.ha)
                }
                when(card){
                    "c2" -> response.add(R.drawable.c2)
                    "c3" -> response.add(R.drawable.c3)
                    "c4" -> response.add(R.drawable.c4)
                    "c5" -> response.add(R.drawable.c5)
                    "c6" -> response.add(R.drawable.c6)
                    "c7" -> response.add(R.drawable.c7)
                    "c8" -> response.add(R.drawable.c8)
                    "c9" -> response.add(R.drawable.c9)
                    "c10" -> response.add(R.drawable.c10)
                    "cj" -> response.add(R.drawable.cj)
                    "cq" -> response.add(R.drawable.cq)
                    "ck" -> response.add(R.drawable.ck)
                    "ca" -> response.add(R.drawable.ca)
                    "d2" -> response.add(R.drawable.d2)
                    "d3" -> response.add(R.drawable.d3)
                    "d4" -> response.add(R.drawable.d4)
                    "d5" -> response.add(R.drawable.d5)
                    "d6" -> response.add(R.drawable.d6)
                    "d7" -> response.add(R.drawable.d7)
                    "d8" -> response.add(R.drawable.d8)
                    "d9" -> response.add(R.drawable.d9)
                    "d10" -> response.add(R.drawable.d10)
                    "dj" -> response.add(R.drawable.dj)
                    "dq" -> response.add(R.drawable.dq)
                    "dk" -> response.add(R.drawable.dk)
                    "da" -> response.add(R.drawable.da)
                    "n" -> response.add(R.drawable.blue_back)
                }
            }
            return response
        }

        fun getStringHands(card: Int): String{
            when(card){
                R.drawable.s2 -> return "s2"
                R.drawable.s3 -> return "s3"
                R.drawable.s4 -> return "s4"
                R.drawable.s5 -> return "s5"
                R.drawable.s6 -> return "s6"
                R.drawable.s7 -> return "s7"
                R.drawable.s8 -> return "s8"
                R.drawable.s9 -> return "s9"
                R.drawable.s10 -> return "s10"
                R.drawable.sj -> return "sj"
                R.drawable.sq -> return "sq"
                R.drawable.sk -> return "sk"
                R.drawable.sa -> return "sa"
                R.drawable.d2 -> return "d2"
                R.drawable.d3 -> return "d3"
                R.drawable.d4 -> return "d4"
                R.drawable.d5 -> return "d5"
                R.drawable.d6 -> return "d6"
                R.drawable.d7 -> return "d7"
                R.drawable.d8 -> return "d8"
                R.drawable.d9 -> return "d9"
                R.drawable.d10 -> return "d10"
                R.drawable.dj -> return "dj"
                R.drawable.dq -> return "dq"
                R.drawable.dk -> return "dk"
                R.drawable.da -> return "da"

            }
            when(card){
                R.drawable.c2 -> return "c2"
                R.drawable.c3 -> return "c3"
                R.drawable.c4 -> return "c4"
                R.drawable.c5 -> return "c5"
                R.drawable.c6 -> return "c6"
                R.drawable.c7 -> return "c7"
                R.drawable.c8 -> return "c8"
                R.drawable.c9 -> return "c9"
                R.drawable.c10 -> return "c10"
                R.drawable.cj -> return "cj"
                R.drawable.cq -> return "cq"
                R.drawable.ck -> return "ck"
                R.drawable.ca -> return "ca"
                R.drawable.h2 -> return "h2"
                R.drawable.h3 -> return "h3"
                R.drawable.h4 -> return "h4"
                R.drawable.h5 -> return "h5"
                R.drawable.h6 -> return "h6"
                R.drawable.h7 -> return "h7"
                R.drawable.h8 -> return "h8"
                R.drawable.h9 -> return "h9"
                R.drawable.h10 -> return "h10"
                R.drawable.hj -> return "hj"
                R.drawable.hq -> return "hq"
                R.drawable.hk -> return "hk"
                R.drawable.ha -> return "ha"
                R.drawable.blue_back -> return "nn"
            }
            return "nn"
        }
        
        fun getPlayersSuitePreFlop(nb: Int): ArrayList<Int>{
            var listPlayerPosition = arrayListOf<Int>()
            when(nb){
                2 ->{
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                }
                3 ->{
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
                4 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
                5 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.button)
                }
                6 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
                7 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
                8 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.utg2)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
                9 ->{
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.utg2)
                    listPlayerPosition.add(R.string.mp)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                }
            }
            Log.e("size","${listPlayerPosition.size}")
            return listPlayerPosition
        }

        fun getPlayersSuitePostFlop(nb: Int): ArrayList<Int>{
            var listPlayerPosition = arrayListOf<Int>()
            when(nb){
                2 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.button)
                }
                3 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.button)
                }
                4 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.button)
                }
                5 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                }
                6 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                }
                7 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                }
                8 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.utg2)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                }
                9 ->{
                    listPlayerPosition.add(R.string.smallblind)
                    listPlayerPosition.add(R.string.bigblind)
                    listPlayerPosition.add(R.string.utg)
                    listPlayerPosition.add(R.string.utg1)
                    listPlayerPosition.add(R.string.utg2)
                    listPlayerPosition.add(R.string.mp)
                    listPlayerPosition.add(R.string.hijack)
                    listPlayerPosition.add(R.string.cutoff)
                    listPlayerPosition.add(R.string.button)
                }
            }
            return listPlayerPosition
        }

    }
}