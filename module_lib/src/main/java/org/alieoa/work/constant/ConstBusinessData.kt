package org.alieoa.work.constant

/**
 * 本地业务标记
 */
class ConstBusinessData {

    // 审批
    class Approve{
        companion object {
            const val LEAVE = 0x000001 // 请假
            const val BUSINESS_TRIP =0x000002 // 出差
            const val SOURCE = 0x000003 // 办公资源
        }
    }
}