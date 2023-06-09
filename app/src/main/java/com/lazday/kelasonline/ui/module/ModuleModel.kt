package com.lazday.kelasonline.ui.module

import com.lazday.kelasonline.ui.course.CourseData
import java.io.Serializable

data class ModuleResponse(
        val status: Boolean,
        val data: ModuleData
)

data class ModuleData (
        val course: CourseData,
        val detail: List<DetailData>
)

data class DetailData (
        val id: Int,
        val title: String,
        val description: String,
        val module_type: String,
        val file_type: String?,
        val document: String,
        val youtube: String,
        val order: String,
        val view: String,
)

data class DetailResponse (
        val data: DetailData
)