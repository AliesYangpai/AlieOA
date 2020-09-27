package org.alieoa.work.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import org.alieoa.work.db.dao.PhoneContactDao
import org.alieoa.work.db.dao.UserDao

@Database(
    entities = [User::class, PhoneContact::class],
    version = 1,
    exportSchema = false
)
abstract class AlieOaDataBase : RoomDatabase() {


    abstract fun getUserDao(): UserDao
    abstract fun getPhoneContactDao(): PhoneContactDao


    companion object {
        @Volatile
        var mInstance: AlieOaDataBase? = null
        fun getInstance(context: Context): AlieOaDataBase {
            return mInstance ?: synchronized(this) {
                mInstance ?: buildDataBase(context).also { mInstance = it }
            }
        }

        private fun buildDataBase(context: Context): AlieOaDataBase {
            return Room
                .databaseBuilder(context, AlieOaDataBase::class.java, "AlieOaDataBase")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }

                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        super.onDestructiveMigration(db)
                    }

                }).build()
        }
    }


}