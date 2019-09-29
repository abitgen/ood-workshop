package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.set.ChoiceSet

interface IChoiceGetter {
    fun getPlayerChoice(): ChoiceSet?
}