package com.abit.cooperatecheatgame

interface IsACopyCat {
    fun getOpponentPreviousChoice(currentRoundIndex: Int): ChoiceSet?
    fun setChoice(currentRoundIndex: Int)
}