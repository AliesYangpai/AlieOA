package org.alieoa.work.entity

data class ReportBean (
    var time: String? = null,
    var name: String? = null,
    var describe: String? = null,
    var avatar: String? = null,
    var type:Short = 0, // 代表是
    var commonTip:String?= null,
    var typeTip  : String? = null
)