package com.abit.cooperatecheatgame.domain.choice

class RandomChoice : IPlayerChoiceProvider{
    override val choice: ChoiceSet
        get() = ChoiceSet.values().random()
}