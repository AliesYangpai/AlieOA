package org.alieoa.work.universal.db.dao

import androidx.room.*
import org.alieoa.work.universal.db.entity.PhoneContact

@Dao
interface PhoneContactDao {
    @Insert
    fun insertPhoneContact(vararg phoneContact: PhoneContact)

    @Delete
    fun deletePhoneContact(vararg phoneContact: PhoneContact)

    @Update
    fun updatePhoneContact(vararg phoneContact: PhoneContact)

    @Query("DELETE FROM PhoneContact")
    fun deleteAllPhoneContacts()

    @Query("SELECT * FROM PhoneContact")
    fun getAllPhoneContacts():List<PhoneContact>
}