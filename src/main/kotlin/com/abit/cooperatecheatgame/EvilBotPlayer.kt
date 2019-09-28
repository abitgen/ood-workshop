package com.abit.cooperatecheatgame

class EvilBotPlayer(name: String) : Player(name) {

    init {
        choice = ChoiceSet.CHEAT
    }
}