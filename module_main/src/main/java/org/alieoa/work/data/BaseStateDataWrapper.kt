package org.alieoa.work.data

/**
 *
 * @property isSuccess Boolean  获取数据成功或失败标记
 * @property isVisible Boolean  目标控件显示或隐藏
 * @property errorMsg String?
 * @constructor
 */
/**
 *
 * @property isSuccess Boolean  获取数据成功或失败标记
 * @property isVisible Boolean  目标控件显示或隐藏
 * @property errorMsg String?   异常文本
 * @property reserve Any?  预留字段
 * @constructor
 */
open class BaseStateDataWrapper(
    var isSuccess: Boolean = true,
    var isVisible: Boolean = true,
    var errorMsg: String? = "",
    var reserve:Any? = null
) {

}