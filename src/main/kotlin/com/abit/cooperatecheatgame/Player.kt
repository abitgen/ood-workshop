package com.abit.cooperatecheatgame

abstract class Player (val name:String, private var score:Int = 0){
    protected open var choice:ChoiceSet? = null
    val choices:ArrayList<ChoiceSet?>? = null
    fun updateScore(update:Int){
        score+=update
    }

    fun getPlayerScore(): Int{
        return score
    }
}
