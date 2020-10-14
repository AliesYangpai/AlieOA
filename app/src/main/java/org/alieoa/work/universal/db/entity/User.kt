package org.alieoa.work.universal.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(@PrimaryKey(autoGenerate = true) var id: Int) {


    constructor() : this(0)

    @ColumnInfo(name = "userId") //这里不写@ColumeInfo那么生成的数据库字段久是变量名称
    var userId: Int = 0

    @ColumnInfo(name = "regionId")
    var regionId: Int = 0

    @ColumnInfo(name = "uuId")
    var uuId: String? = null

    @ColumnInfo(name = "cardType")
    var cardType: Int = 0

    @ColumnInfo(name = "phone")
    var phone: String? = null

    @ColumnInfo(name = "userName")
    var userName: String? = null

    @ColumnInfo(name = "avatar")
    var avatar: String? = null

    @ColumnInfo(name = "fullName")
    var fullName: String? = null

    @ColumnInfo(name = "nickName")
    var nickName: String? = null

    @ColumnInfo(name = "identifyCard")
    var identifyCard: String? = null

    @ColumnInfo(name = "icNumber")
    var icNumber: String? = null

    @ColumnInfo(name = "balance")
    var balance: Float = 0F

    @ColumnInfo(name = "createTime")
    var createTime: String? = null

    @ColumnInfo(name = "lastLoginTime")
    var lastLoginTime: String? = null

    @ColumnInfo(name = "currentLoginTime")
    var currentLoginTime: String? = null

    @ColumnInfo(name = "userLevel")
    var userLevel: Int = 0

    @ColumnInfo(name = "userPoint")
    var userPoint: Int = 0


    override fun toString(): String {
        return "User(id=$id, userId=$userId, regionId=$regionId, uuId=$uuId, cardType=$cardType, phone=$phone, userName=$userName, avatar=$avatar, fullName=$fullName, nickName=$nickName, identifyCard=$identifyCard, icNumber=$icNumber, balance=$balance, createTime=$createTime, lastLoginTime=$lastLoginTime, currentLoginTime=$currentLoginTime, userLevel=$userLevel, userPoint=$userPoint)"
    }


}