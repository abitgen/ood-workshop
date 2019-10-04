package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.domain.choice.ChoiceSet

class EvilBotPlayer(name: String) : Player(name), IsBot {

    init {
        choice = ChoiceSet.CHEAT
    }
}