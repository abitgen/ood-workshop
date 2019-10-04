package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.domain.choice.ChoiceSet
import com.abit.cooperatecheatgame.domain.choice.IChoiceSetter


class RealPlayer(name: String) : Player(name), IChoiceSetter {

    override fun setPlayerChoice(choice: ChoiceSet?){
        this.choice = choice
    }
}