package com.lazday.kelasonline.ui.course

import com.lazday.kelasonline.network.ApiService
import kotlinx.coroutines.*

class CoursePresenter (
        private val view: CourseView,
        private val api: ApiService,
) {

    init {
        view.setupListener()
        fetchCategory()
        fetchCourse("")
    }

    fun fetchCourse(keyword: String) {
        view.courseLoading(true)
        GlobalScope.launch {
            val response = api.course( keyword )
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    view.courseResponse( response.body()!! )
                    view.courseLoading(false)
                }
            } else {
                view.courseError("Terjadi kesalahan")
            }
        }
    }

    //-------- FUNCTION UNTUK FETCH DATA CATEGORY DARI API ------------//
    fun fetchCategory() {
        view.courseLoading(true)
        GlobalScope.launch {
            val response = api.category()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    view.categoryResponse( response.body()!! )
                    view.courseLoading(false)
                }
            } else {
                view.courseError("Terjadi kesalahan")
            }
        }
    }

    //-------- FUNCTION UNTUK FETCH DATA RESEP DARI API ------------//
    fun fetchCourse(categoryId: Int) {
        view.courseLoading(true)
        GlobalScope.launch {
            val response = api.courseByCategory( categoryId )
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    view.courseResponse( response.body()!! )
                    view.courseLoading(false)
                }
            } else {
                view.courseError("Terjadi kesalahan")
            }
        }
    }

}

interface CourseView {
    fun setupListener()
    fun courseLoading(loading: Boolean)
    fun courseResponse(response: CourseResponse)
    fun categoryResponse(response: CategoryResponse)
    fun courseError(msg: String)
}