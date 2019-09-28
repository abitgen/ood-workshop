package com.abit.cooperatecheatgame

interface ChoiceProvider {
    fun getPlayerChoice(): ChoiceSet?
    fun setPlayerChoice(choice: ChoiceSet?)
}