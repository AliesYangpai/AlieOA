package org.alieoa.work.handler

/**
 * 数据处理基类
 * @param Data
 */
abstract class BaseDataHandler<Data> {
    fun onHandleData(result: Result<Data>) {
        when (result.isSuccess) {
            true -> onHandleDataSuccess(result.isSuccess, result.getOrNull())
            else -> onHandleDataError(result.isSuccess, result.exceptionOrNull()?.localizedMessage)
        }
    }


    /**
     * 正常的数据返回处理
     * @param ret Boolean
     * @param data Data?
     */
    protected abstract fun onHandleDataSuccess(ret: Boolean, data: Data?)


    /**
     * 异常数据返回处理
     * @param ret Boolean
     * @param msg String?
     */
    protected abstract fun onHandleDataError(ret: Boolean, msg: String?)

}