package org.alieoa.work.entity

import org.alieoa.work.constant.ConstLocalData


data class WorkSectionAll(
    val title: String = "",
    val name: String = "",
    val time: String = "",
    val avatar: String = "",
    val previewPicUrls: ArrayList<String>? = null,
    val commonTip: String = "",
    val type:Int = 0,
    val describe:String = "",
)

data class WorkSectionReport (
    val time: String = "",
    val name: String = "",
    val describe: String = "",
    val avatar: String = "",
    val type:Short = 0, // 代表是
    val commonTip:String= "",
    val typeTip  : String = ""
)

data class WorkSectionClient (
    val name:String= "",
    val age:Short = 0,
    val gender:Char = ConstLocalData.GENDER_UNKNOWN,
    val avatar:String = "",
    val describe:String="",
    val time:String= "",
)

data class WorkSectionApprove(
    val time: String = "",
    val approveName: String = "",
    val describe: String = "",
    val approveAvatar: String = "",
    val approveType:Short = 0,
    val approveCommonTip:String= "",
    val approveTypeTip  : String = ""
)

data class WorkSectionAnnounce(
    val title:String = "",
    val time: String = "",
    val author:String = "",
    val thumbnail:String = "",
)