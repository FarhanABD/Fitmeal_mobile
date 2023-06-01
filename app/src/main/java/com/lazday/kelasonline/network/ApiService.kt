package com.lazday.kelasonline.network

import com.lazday.kelasonline.ui.course.CategoryResponse
import com.lazday.kelasonline.ui.course.CourseResponse
import com.lazday.kelasonline.ui.home.HomeResponse
import com.lazday.kelasonline.ui.login.LoginData
import com.lazday.kelasonline.ui.login.LoginResponse
import com.lazday.kelasonline.ui.module.DetailResponse
import com.lazday.kelasonline.ui.module.ModuleResponse
import com.lazday.kelasonline.ui.profile.AvatarResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("api/login")
    suspend fun login(
            @Query("email") email: String,
            @Query("password") password: String
    ) : Response<LoginResponse>

//    @POST("api/login")
//    fun login(@Body loginData: LoginData): Call<LoginResponse>

//    @POST("api/login")
//    fun login(
//        @Query("email") email: String,
//        @Query("password") password: String,
//    ) : Response<LoginResponse>

    @GET("api/course")
    suspend fun course(
            @Query("keyword") keyword: String,
    ) : Response<CourseResponse>

//    @GET("api/resep")
//    suspend fun course(
//        @Query("keyword") keyword: String,
//    ) : Response<CourseResponse>

    @GET("api/category")
    suspend fun category() : Response<CategoryResponse>

    @POST("api/course-by-category")
    suspend fun courseByCategory(
            @Query("category_id") category_id: Int
    ) : Response<CourseResponse>

//    @POST("api/resep-by-category")
//    suspend fun courseByCategory(
//        @Query("category_id") category_id: Int
//    ) : Response<CourseResponse>

    @POST("api/course-by-id")
    suspend fun courseById(
        @Query("id") id: Int
    ) : Response<ModuleResponse>

//    @POST("api/resep-by-id")
//    suspend fun courseById(
//        @Query("id") id: Int
//    ) : Response<ModuleResponse>

    @POST("api/module-by-id")
    suspend fun moduleById(
        @Query("id") id: Int
    ) : Response<DetailResponse>

    @GET("api/home")
    suspend fun home() : Response<HomeResponse>

    @Multipart
    @POST("api/avatar")
    suspend fun avatar(
            @Part avatar: MultipartBody.Part,
            @Query("id") id: Int
    ) : Response<AvatarResponse>


}