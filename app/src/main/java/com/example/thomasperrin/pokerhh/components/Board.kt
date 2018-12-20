package com.example.thomasperrin.pokerhh.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.thomasperrin.pokerhh.R

class Board: FrameLayout {

    var view: View

    var card1: ImageView
    var card2: ImageView
    var card3: ImageView
    var card4: ImageView
    var card5: ImageView

    var isFlop: Boolean = false
    var isTurn: Boolean = false
    var isRiver: Boolean = false

    var resources: ArrayList<Int> = arrayListOf()
    var stringValues: ArrayList<String> = arrayListOf()

    constructor(context: Context) : this(context,null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.component_board, this, true)
        card1 = view.findViewById(R.id.card1)
        card2 = view.findViewById(R.id.card2)
        card3 = view.findViewById(R.id.card3)
        card4 = view.findViewById(R.id.card4)
        card5 = view.findViewById(R.id.card5)
    }

    fun setFlop(resources: ArrayList<Int>, stringValues: List<String>){
        if(resources.size == 3 && stringValues.size == 3) {
            card1.setImageResource(resources[0])
            card2.setImageResource(resources[1])
            card3.setImageResource(resources[2])
            this.resources.addAll(resources)
            this.stringValues.addAll(stringValues)
            isFlop = true
        }
    }

    fun setTurn(resources: Int, stringValue: String){
        card4.setImageResource(resources)
        this.resources.add(resources)
        this.stringValues.add(stringValue)
        isTurn = true
    }

    fun setRiver(resources: Int, stringValue: String){
        card5.setImageResource(resources)
        this.resources.add(resources)
        this.stringValues.add(stringValue)
        isRiver = true
    }

    fun backCard(){
        when {
            isRiver -> {
                card5.setImageResource(R.drawable.blue_back)
                this.resources.removeAt(this.resources.size-1)
                this.stringValues.removeAt(this.stringValues.size-1)
                isRiver = false
            }
            isTurn -> {
                card4.setImageResource(R.drawable.blue_back)
                this.resources.removeAt(this.resources.size-1)
                this.stringValues.removeAt(this.stringValues.size-1)
                isTurn = false
            }
            isFlop -> {
                card3.setImageResource(R.drawable.blue_back)
                card2.setImageResource(R.drawable.blue_back)
                card1.setImageResource(R.drawable.blue_back)
                this.resources.clear()
                this.stringValues.clear()
                isFlop = false
            }
        }
    }


}