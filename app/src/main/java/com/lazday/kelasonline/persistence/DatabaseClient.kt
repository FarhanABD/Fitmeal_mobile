package com.lazday.kelasonline.persistence

import android.content.Context
import androidx.room.Room

//private const val dbName = "KelasOnlineLazday.db"
private const val dbName = "kelasonline"

object DatabaseClient{
    fun getService( context: Context ): DatabaseService {
        return Room.databaseBuilder(
            context,
            DatabaseService::class.java,
            dbName
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}