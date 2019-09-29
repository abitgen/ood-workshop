package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.set.ChoiceSet
import com.abit.cooperatecheatgame.set.PlayerType
import java.util.*

class RealCliChoice(private val playerName: String) : IPlayerChoiceProvider {
    override val choice: ChoiceSet?
        get() = getUserInput()

    private fun getUserInput(): ChoiceSet? {
        print("\n Enter $playerName choice : ")
        val sc = Scanner(System.`in`)
        val readText = sc.nextLine()
        val choiceFromUser = ChoiceSet.values().firstOrNull { it.userCode == readText}

        return if(choiceFromUser == null){
            System.err.print("ERROR >>>>> Please enter valid code : `${ChoiceSet.COOPERATE.userCode}` for ${ChoiceSet.COOPERATE} & `${ChoiceSet.CHEAT.userCode}` for ${ChoiceSet.CHEAT} \n")
            getUserInput()
        }else{
            choiceFromUser
        }
    }
}