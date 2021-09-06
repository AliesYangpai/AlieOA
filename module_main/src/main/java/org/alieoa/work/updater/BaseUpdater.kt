package org.alieoa.work.updater

import org.alieoa.work.data.BaseStateDataWrapper

abstract class BaseUpdater<StateDataWrapper:BaseStateDataWrapper> {
   val tag = this.javaClass.simpleName
   abstract fun onUpdate(stateDataWrapper: StateDataWrapper)
}