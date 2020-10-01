package org.alieoa.work.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PhoneContact")
data class PhoneContact(
    @PrimaryKey(autoGenerate = true)
    var id: Int
) {

    constructor() : this(0)

    @ColumnInfo(name = "contactId")
    var contactId: Long = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "avatar")
    var avatar: String? = null

    @ColumnInfo(name = "contactNo")
    var contactNo: String? = null

    @ColumnInfo(name = "pinyin")
    var pinyin: String? = null

    @ColumnInfo(name = "pinyinShort")
    var pinyinShort: String? = null
    override fun toString(): String {
        return "PhoneContact(id=$id, contactId=$contactId, contactName=$contactName, avatar=$avatar, contactNo=$contactNo, pinyin=$pinyin, pinyinShort=$pinyinShort)"
    }


}