package com.abit.cooperatecheatgame.domain.choice

import com.abit.cooperatecheatgame.domain.choice.IPlayerChoiceProvider
import com.abit.cooperatecheatgame.domain.choice.*

enum class ChoiceEnterType(val value: (String) -> IPlayerChoiceProvider) {
    CLI({ RealCliChoice(it) }),
    RANDOM({ RandomChoice() })
}