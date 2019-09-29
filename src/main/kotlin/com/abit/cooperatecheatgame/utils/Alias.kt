package com.abit.cooperatecheatgame.utils

import com.abit.cooperatecheatgame.domain.game.GameMachine
import com.abit.cooperatecheatgame.domain.player.Player

typealias InitGameMachine = (List<Player>)-> GameMachine

typealias PlayerDelegate = (Player)->Player