package org.alieoa.work.entity

import org.alieoa.work.constant.ConstLocalData

data class ClientBean (
    var name:String?= null,
    var age:Short = 0,
    var gender:Char = ConstLocalData.GENDER_UNKNOWN,
    var avatar:String = "",
    var describe:String?=null,
    var time:String?= null,
)