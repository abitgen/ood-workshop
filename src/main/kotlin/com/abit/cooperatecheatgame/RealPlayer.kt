package com.abit.cooperatecheatgame

class RealPlayer(name: String) : Player(name), IMakeChoice, ChoiceProvider {

    override fun makeChoice(choice: ChoiceSet): ChoiceSet {
       updateCoice(choice)
        return choice
    }

    fun updateCoice(choice: ChoiceSet){
        this.choice = choice
    }

    override fun getPlayerChoice(): ChoiceSet? {
        return choice
    }

    override fun setPlayerChoice(choice: ChoiceSet?){
        this.choice = choice
        choices?.add(choice)
    }
}