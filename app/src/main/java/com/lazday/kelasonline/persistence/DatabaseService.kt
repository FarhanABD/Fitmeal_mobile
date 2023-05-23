package com.lazday.kelasonline.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Course::class],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}