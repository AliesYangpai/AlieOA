package org.alieoa.work.db.dao

import androidx.room.*
import org.alieoa.work.db.PhoneContact

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