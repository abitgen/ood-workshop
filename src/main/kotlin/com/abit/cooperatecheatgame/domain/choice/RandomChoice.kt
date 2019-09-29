package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.set.ChoiceSet

class RandomChoice : IPlayerChoiceProvider{
    override val choice: ChoiceSet
        get() = ChoiceSet.values().random()
}