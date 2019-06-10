package com.example.myapp.mynearbuygetter.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.myapp.mynearbuygetter.dao.RegisterDAO
import com.example.myapp.mynearbuygetter.entity.RegisterEntity


@Database(entities = [RegisterEntity::class], version = 1)
public abstract class AppDatabase : RoomDatabase() {

    abstract fun registerDao(): RegisterDAO

    companion object {
        private var databaseInstance: AppDatabase?= null

        fun getInstance(context: Context): AppDatabase?{
            if(databaseInstance==null){
                synchronized(AppDatabase::class){
                    databaseInstance=Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "getapp_database"
                    )
                            //.fallbackToDestructiveMigration()
                            //.addCallback(roomCallback)
                            .build()

                }
            }

            return  databaseInstance
        }
    }

}