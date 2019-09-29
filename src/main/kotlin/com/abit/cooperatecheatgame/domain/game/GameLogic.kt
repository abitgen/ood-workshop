package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.set.ChoiceSet

class GameLogic {
    fun computeLogic(a: ChoiceSet?, b: ChoiceSet?) :Pair<Int,Int>{
        return when {
            (a == ChoiceSet.COOPERATE && b == ChoiceSet.COOPERATE) -> Pair(2,2)
            (a == ChoiceSet.COOPERATE && b == ChoiceSet.CHEAT) -> Pair(-1, 3)
            (a == ChoiceSet.CHEAT && b == ChoiceSet.COOPERATE) -> Pair(3, -1)
            (a == ChoiceSet.CHEAT && b == ChoiceSet.CHEAT) -> Pair(0, 0)
            else -> Pair(0,0)
        }
    }
}