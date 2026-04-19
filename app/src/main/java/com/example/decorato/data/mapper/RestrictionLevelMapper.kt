package com.example.decorato.data.mapper

import com.example.decorato.domain.utils.RestrictionLevel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun RestrictionLevel.toLocalDto(): String {
    return when (this) {
        RestrictionLevel.STRICT -> "STRICT"
        RestrictionLevel.MODERATE -> "MODERATE"
        RestrictionLevel.OFF -> "OFF"
        RestrictionLevel.GUEST -> "GUEST" // ✅ ضيفي السطر ده هنا
    }
}

fun stringToRestrictionLevelEntity(restrictionLevel: Flow<String>): Flow<RestrictionLevel> {
    return flow {
        restrictionLevel.collect {
            emit(
                when (it) {
                    "STRICT" -> RestrictionLevel.STRICT
                    "MODERATE" -> RestrictionLevel.MODERATE
                    "GUEST" -> RestrictionLevel.GUEST // ✅ ضيفي السطر ده هنا
                    else -> RestrictionLevel.OFF

                }
            )
        }
    }
}
