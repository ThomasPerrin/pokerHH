package com.example.thomasperrin.pokerhh.utils

import com.example.thomasperrin.pokerhh.R

enum class Position {

    BU {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.button
    },
    CO {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.cutoff
    },
    HJ {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.hijack
    },
    B3 {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.button3
    },
    B4 {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.button4
    },
    B5 {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.button5
    },
    B6 {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.button6
    },
    SB {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.smallblind
    },
    BB {
        override fun getIntValue() = 0
        override fun getStringValue() = R.string.bigblind
    };


    abstract fun getStringValue(): Int
    abstract fun getIntValue(): Int


}