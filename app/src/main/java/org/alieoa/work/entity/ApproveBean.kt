package org.alieoa.work.entity

data class ApproveBean(
    var time: String? = null,
    var approveName: String? = null,
    var describe: String? = null,
    var approveAvatar: String? = null,
    var approveType:Short = 0,
    var approveCommonTip:String?= null,
    var approveTypeTip  : String? = null
)