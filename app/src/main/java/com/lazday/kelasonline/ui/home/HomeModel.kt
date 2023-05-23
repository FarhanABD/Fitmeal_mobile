package com.lazday.kelasonline.ui.home

import com.lazday.kelasonline.ui.course.CourseData

data class HomeResponse(
        val data: HomeData
)

data class HomeData(
        val latest: List<CourseData>,
        val popular: List<CourseData>,
)