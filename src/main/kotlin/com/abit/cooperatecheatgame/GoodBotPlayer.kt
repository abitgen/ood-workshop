package com.abit.cooperatecheatgame

class GoodBotPlayer(name: String) : Player(name) {

    init {
        choice = ChoiceSet.COOPERATE
    }
}