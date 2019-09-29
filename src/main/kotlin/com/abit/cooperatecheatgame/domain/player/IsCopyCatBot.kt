package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.domain.player.IsBot

interface IsCopyCatBot : IsBot {
    fun setPlayerChoice(currentRoundIndex: Int)
}