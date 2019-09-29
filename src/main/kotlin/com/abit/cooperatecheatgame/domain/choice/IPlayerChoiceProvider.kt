package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.set.ChoiceSet

interface IPlayerChoiceProvider {
    val choice: ChoiceSet?
}