package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet
import com.abit.cooperatecheatgame.domain.choice.IChoiceGetter

abstract class Player (val name:String) : IChoiceGetter {

    private var score:Int = 0
    protected open var choice: ChoiceSet? = null
    val choices = mutableListOf<ChoiceSet?>()

    fun updateScore(update:Int){
        score += update
    }

    fun getPlayerScore(): Int{
        return score
    }

    override fun getPlayerChoice(): ChoiceSet? {
        return choice
    }
}
