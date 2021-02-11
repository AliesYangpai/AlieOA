package org.alieoa.work.entity

import org.alieoa.work.constant.ConstLocalData

data class ClientBean (
    var mId:Int = 0,
    var mName:String?= null,
    var mAge:Short = 0,
    var mGender:Char = ConstLocalData.GENDER_UNKNOWN,
    var mAvatar:String = "",
    var mMsg:String?=null,
    var time:String?= null,
)