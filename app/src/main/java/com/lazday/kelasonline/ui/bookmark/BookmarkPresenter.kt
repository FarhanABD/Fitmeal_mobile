package com.lazday.kelasonline.ui.bookmark

import com.lazday.kelasonline.persistence.Course
import com.lazday.kelasonline.persistence.CourseDao
import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.util.userLogin
import kotlinx.coroutines.*

class BookmarkPresenter (
    private val view: BookmarkView,
    private val db: CourseDao,
    private val pref: PrefManager,
) {

    val listBookmark = db.findAll(userId = userLogin(pref).id)

    fun remove(course: Course) {
        GlobalScope.launch {
            db.remove(course)
        }
    }
}

interface BookmarkView {
    fun setupListener()
}