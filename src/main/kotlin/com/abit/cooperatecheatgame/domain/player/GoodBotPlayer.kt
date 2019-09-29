package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class GoodBotPlayer(name: String) : Player(name), IsBot {

    init {
        choice = ChoiceSet.COOPERATE
    }
}