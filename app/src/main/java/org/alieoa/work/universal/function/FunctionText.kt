package org.alieoa.work.universal.function

import org.alieoa.work.universal.logic.LogicName

class FunctionText {
    var mLogicName: LogicName = LogicName()

    fun generateTargetName(name: String): String = when {
        mLogicName.is1WordName(name) -> name
        mLogicName.is2WordName(name) -> name
        mLogicName.is3WordName(name) -> name.substring(1)
        mLogicName.is4WordName(name) -> name.substring(2)
        else -> name.substring(name.length - 2)
    }
}