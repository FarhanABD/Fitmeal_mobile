package com.lazday.kelasonline.ui.module

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.lazday.kelasonline.R
import com.lazday.kelasonline.databinding.ActivityModuleBinding
import com.lazday.kelasonline.network.ApiClient
import com.lazday.kelasonline.persistence.DatabaseClient
import com.lazday.kelasonline.preferences.PrefManager
import com.lazday.kelasonline.ui.BaseActivity
import com.lazday.kelasonline.ui.course.CourseData
import com.lazday.kelasonline.util.loadImage

class ModuleActivity : BaseActivity(), ModuleView {

    private val binding by lazy { ActivityModuleBinding.inflate( layoutInflater ) }
    private lateinit var presenter: ModulePresenter
    private lateinit var adapter: ModuleAdapter
    private lateinit var course: CourseData
    private val id by lazy { intent.getIntExtra("id", 0 ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = ModulePresenter(
            this,
            ApiClient.getService(),
            DatabaseClient.getService(this).courseDao(),
            PrefManager(this)
        )
    }

    override fun onStart() {
        super.onStart()
        if (id != 0) {
            presenter.fetchModule(id)
            presenter.find(id)
        }
    }

    override fun setupListener() {
        adapter = ModuleAdapter(arrayListOf(), object : ModuleAdapter.AdapterListener {
            override fun onClick(detail: DetailData) {
                startActivity(
                    Intent(this@ModuleActivity, DetailActivity::class.java)
                        .putExtra("id", detail.id)
                )
            }
        })
        binding.listModule.adapter = adapter
        binding.imageBookmark.setOnClickListener {
            if (this::course.isInitialized) presenter.addBookmark( course )
        }
        binding.swipe.setOnRefreshListener {
            if (id != 0) {
                presenter.fetchModule(id)
                presenter.find(id)
            }
        }
    }

    override fun moduleLoading(loading: Boolean) {
        binding.swipe.isRefreshing = loading
    }

    //---------------- FUNCTION MEMUNCULKAN MODULE -----------------//
    override fun moduleResponse(response: ModuleResponse) {

        course = response.data.course
        val module = response.data.detail
        Log.e("module_", module.toString())

        loadImage( binding.imageCover, course.thumbnail )
        binding.textTitle.text = course.title
        binding.textMentor.text = course.mentor
//        binding.textMentor.text = course.chef

        adapter.addList( module )
        binding.textModules.text = "${module.size} Resep"

        //-------- FUNCTION VIEWS PADA HALAMAN MODULE -----------//
        var views = 0
        module.forEach {
            views += it.view.toInt()
            binding.textViews.text = "${views}x dilihat"
        }

        binding.buttonLink.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse( course.group )
            startActivity(openURL)
        }
    }

    //---------- FUNCTION JIKA MODULE ERROR -------------//
    override fun moduleError(msg: String) {
        binding.swipe.isRefreshing = false
    }

    //------- FUNGSI CLICK ICON BOOKMARK ------------------//
    override fun isBookmark(bookmark: Int) {
        Log.e("isBookmark", "bookmark $bookmark")
        when (bookmark) {
            1 -> binding.imageBookmark.setImageResource( R.drawable.ic_bookmark_added )
            else -> binding.imageBookmark.setImageResource( R.drawable.ic_bookmark_add )
        }
    }
}