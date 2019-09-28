package com.abit.cooperatecheatgame

class CopyCatBotPlayer(name: String, opponent: Player) : Player(name), IsACopyCat {
    lateinit var opponent: Player

    init {
        this.opponent = opponent
    }

    override fun getOpponentPreviousChoice(currentRoundIndex: Int): ChoiceSet? {
        return if (currentRoundIndex == 0) ChoiceSet.COOPERATE
        else opponent.choices?.get(currentRoundIndex - 1)
    }

    override fun setChoice(currentRoundIndex: Int) {
        choice = getOpponentPreviousChoice(currentRoundIndex)
    }
}