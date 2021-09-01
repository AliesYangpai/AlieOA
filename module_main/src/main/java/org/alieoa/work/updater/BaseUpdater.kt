package org.alieoa.work.updater

import org.alieoa.work.data.BaseStateDataWrapper

abstract class BaseUpdater<StateDataWrapper:BaseStateDataWrapper> {

   abstract fun onUpdate(stateDataWrapper: StateDataWrapper)
}