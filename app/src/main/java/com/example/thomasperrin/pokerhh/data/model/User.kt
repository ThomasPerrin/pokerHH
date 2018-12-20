package com.example.thomasperrin.pokerhh.data.model

data class User(val name: String,val isAdmin: Boolean){

    var a = 0

    init {

    }

    fun main(args: Array<String>){
        val b = Number()
        b addNumber 4
        b.x
    }

    infix fun inlineS(a: Int){

    }

}

class Number{
    var x = 5
    infix fun addNumber(num: Int){
        this.x = x + num
    }
}