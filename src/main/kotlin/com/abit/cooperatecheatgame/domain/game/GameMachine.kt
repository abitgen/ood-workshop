package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.choice.IChoiceSetter
import com.abit.cooperatecheatgame.domain.player.IBotChoiceSetter
import com.abit.cooperatecheatgame.utils.PresentScore
import com.abit.cooperatecheatgame.domain.player.IsBot
import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.set.ChoiceEnterType
import com.abit.cooperatecheatgame.set.PlayerType
import java.lang.NullPointerException

class GameMachine(private val playerMap : Map<PlayerType, Player>, private val logic: GameLogic, private val presentScore: PresentScore) {

    private fun isReal(playerObj: Player) = playerObj !is IsBot

    private fun getPlayer(playerType: PlayerType) = playerMap[playerType]

    fun setRealPlayerChoices(choiceEnterType: ChoiceEnterType?){
        if(atleastOneRealPlayer() && choiceEnterType==null)
            throw NullPointerException("ChoiceProvider should not be null for Real Player")
        playerMap.forEach { (type, player) ->
            if(isReal(player) && player is IChoiceSetter) {
                player.setPlayerChoice(choiceEnterType?.value?.invoke(player.name)?.choice)
                player.choices.add(player.getPlayerChoice())
            }
        }
    }

    fun setBotPlayerChoices(roundId:Int){
        playerMap.forEach { (type, player) ->
            if(!isReal(player)) {
                if (player is IBotChoiceSetter) {
                    player.setPlayerChoice(roundId)
                }
                player.choices.add(player.getPlayerChoice())
            }
        }
    }

    private fun atleastOneRealPlayer() = playerMap.count { isReal(it.value) && it.value is IChoiceSetter } > 0

    fun startRound(id:Int){
        val round = Round(id)
        val scoreMap = round.startRound(playerMap, logic)
        getPlayer(PlayerType.PLAYER1)?.updateScore(scoreMap[PlayerType.PLAYER1] ?: 0)
        getPlayer(PlayerType.PLAYER2)?.updateScore(scoreMap[PlayerType.PLAYER2] ?: 0)
    }

    fun showRoundInfo() {
        presentScore.doPrintSeparator()
        presentScore.doPrintRound(getPlayer(PlayerType.PLAYER1))
        presentScore.doPrintRound(getPlayer(PlayerType.PLAYER2))
        presentScore.doPrintSeparator()
    }

    fun onGameOver() {
        presentScore.doPrintGameOver(getPlayer(PlayerType.PLAYER1))
        presentScore.doPrintGameOver(getPlayer(PlayerType.PLAYER2))
    }

}