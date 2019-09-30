package com.abit.cooperatecheatgame.domain.game

enum class GameType(val mode:()->IGameMode) {
    NORMAL({ NormalGame() }),
    TOURNAMENT({ TournamentGame() })
}