package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.utils.PlayerDelegate

enum class GameType(val mode:(List<PlayerDelegate>)->IGameMode) {
    NORMAL({ NormalGame() }),
    TOURNAMENT({ TournamentGame(it) })
}