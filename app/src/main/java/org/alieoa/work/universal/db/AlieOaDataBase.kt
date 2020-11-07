package org.alieoa.work.universal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import org.alieoa.work.universal.db.dao.PhoneContactDao
import org.alieoa.work.universal.db.dao.UserDao
import org.alieoa.work.universal.db.entity.PhoneContact
import org.alieoa.work.universal.db.entity.User

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
//                .addMigrations(MIGRATION_1_2)
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


        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // TODO("Not yet implemented")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //  TODO("Not yet implemented")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //  TODO("Not yet implemented")
            }

        }
    }


}