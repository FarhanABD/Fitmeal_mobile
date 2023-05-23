package com.lazday.kelasonline.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(course: Course)

    @Update
    suspend fun update(course: Course)

    @Delete
    suspend fun remove(course: Course)

    @Query("SELECT * FROM tableCourse WHERE user_id=:userId")
    fun findAll(userId: Int): LiveData<List<Course>>

    @Query("SELECT COUNT(id) FROM tableCourse WHERE id=:id AND user_id=:userId")
    fun find(id: Int, userId: Int): Int

    @Query("SELECT COUNT(id) FROM tableCourse WHERE user_id=:userId")
    fun count(userId: Int): Int
}