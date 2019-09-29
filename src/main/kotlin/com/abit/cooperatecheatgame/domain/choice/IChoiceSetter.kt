package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.set.ChoiceSet

interface IChoiceSetter {
    fun setPlayerChoice(choice: ChoiceSet?)
}