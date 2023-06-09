package com.lazday.kelasonline.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableCourse")
data class Course (
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val user_id: Int,
        val thumbnail: String,
        val title: String,
        val mentor: String,
)
//data class Course (
//        @PrimaryKey(autoGenerate = false)
//        val id: Int,
//        val user_id: Int,
//        val thumbnail: String,
//        val title: String,
//        val chef: String,
//)