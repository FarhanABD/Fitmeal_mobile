package com.lazday.kelasonline.ui.home

import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.network.ApiService
import com.lazday.kelasonline.ui.login.LoginData
import com.lazday.kelasonline.util.userLogin
import kotlinx.coroutines.*

class HomePresenter (
    private val view: HomeView,
    private val pref: PrefManager,
    private val api: ApiService,
) {

    init {
        view.setupListener()
        view.user( userLogin( pref ) )
        fetchHome()
    }

    fun fetchHome() {
        view.homeLoading(true)
        GlobalScope.launch {

            val response = api.home()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    view.homeResponse( response.body()!! )
                    view.homeLoading(false)
                }
            } else {
                view.homeError("Terjadi kesalahan")
            }
        }
    }
}

interface HomeView {
    fun setupListener()
    fun user(user: LoginData)
    fun homeLoading(loading: Boolean)
    fun homeResponse(response: HomeResponse)
    fun homeError(msg: String)
}