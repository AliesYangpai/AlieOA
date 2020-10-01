package org.alieoa.work.db.dao

import androidx.room.*
import org.alieoa.work.db.entity.User

/**
 * 用户的dao,用于进行用户增删改查
 */
@Dao
interface UserDao {
    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(vararg user: User)

    @Update
    fun updateUser(vararg user: User)

    @Query("DELETE FROM User")
    fun deleteAllUser()

    @Query("SELECT * FROM User ORDER BY ID")
    fun getAllUsers():List<User>

}