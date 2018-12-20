package com.example.thomasperrin.pokerhh.ui.newhand.newhand

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.data.model.History
import com.google.android.material.button.MaterialButton
import java.util.*

class NewHandAdapter (private val fragment: NewHandFragment) : RecyclerView.Adapter<NewHandAdapter.NewHandViewHodler>() {

    private var mHands: ArrayList<History>? = null
    private var mBackgrounds: ArrayList<Int>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NewHandAdapter.NewHandViewHodler {
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_all_hands, viewGroup, false)
        return NewHandViewHodler(view)
    }

    override fun onBindViewHolder(newHandViewHolder: NewHandAdapter.NewHandViewHodler, i: Int) {
        newHandViewHolder.bind(mHands!![i], mBackgrounds!![i], fragment)
    }

    override fun getItemCount(): Int {
        return if (mHands != null)
            mHands!!.size
        else
            0
    }

    fun setData(mHistories: ArrayList<History>) {
        if(this.mHands == null)
            this.mHands = arrayListOf()
        if(this.mBackgrounds == null)
            this.mBackgrounds = arrayListOf()
        this.mHands = mHistories

        for(history in mHistories){
            val r = Random().nextInt(4)
            when(r){
                0->mBackgrounds!!.add(R.drawable.background_poker_blue)
                1->mBackgrounds!!.add(R.drawable.background_poker_green)
                2->mBackgrounds!!.add(R.drawable.background_table_poker_orange)
                3->mBackgrounds!!.add(R.drawable.background_table_poker_red)
            }
        }

        notifyDataSetChanged()
    }

    fun resetDatas(){
        mHands!!.clear()
        mBackgrounds!!.clear()
    }

    class NewHandViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var namePlayer: TextView = itemView.findViewById(R.id.namePlayer)
        var description: TextView = itemView.findViewById(R.id.description)
        var more: TextView = itemView.findViewById(R.id.more)

        var backgroundCard: AppCompatImageView = itemView.findViewById(R.id.backgroundCard)

        var see: MaterialButton = itemView.findViewById(R.id.see)
        var delete: MaterialButton = itemView.findViewById(R.id.delete)

        var card1: AppCompatImageView = itemView.findViewById(R.id.card1)
        var card2: AppCompatImageView = itemView.findViewById(R.id.card2)
        var share: AppCompatImageView = itemView.findViewById(R.id.share)
        var like: AppCompatImageView = itemView.findViewById(R.id.like)
        var avatar: AppCompatImageView = itemView.findViewById(R.id.avatar)

        fun bind(history: History?, background:Int, fragment: NewHandFragment) {
            if(history==null)
                return

            Glide.with(fragment).load(background).into(backgroundCard)
            Glide.with(fragment).load(R.drawable.d8).into(card1)
            Glide.with(fragment).load(R.drawable.sa).into(card2)

        }

    }
}