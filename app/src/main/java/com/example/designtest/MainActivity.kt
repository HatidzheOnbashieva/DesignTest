package com.example.designtest

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.designtest.databinding.ActivityMainBinding
import android.view.WindowManager
import android.app.Activity
import android.graphics.Rect
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var gendersAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


//        val rect = Rect()
//        val win = this.window
//        win.decorView.getWindowVisibleDisplayFrame(rect)
//        val statusBarHeight = rect.top
//        val contentViewTop = win.findViewById<View>(Window.ID_ANDROID_CONTENT).top
//        val titleBarHeight = contentViewTop - statusBarHeight
//
//        val view = viewBinding.vView
//        val params: ConstraintLayout.LayoutParams = view.layoutParams as ConstraintLayout.LayoutParams
//        params.topMargin = titleBarHeight
//        view.layoutParams = params

        //WindowCompat.setDecorFitsSystemWindows(window, true)


        ViewCompat.setOnApplyWindowInsetsListener(viewBinding.vView) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            val params: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            params.topMargin = insets.top
//            params.leftMargin = insets.left
//            params.bottomMargin = insets.bottom
//            params.rightMargin = insets.right
            view.layoutParams = params

            // Return CONSUMED if you don't want want the window insets to keep being
            // passed down to descendant views.
            WindowInsetsCompat.CONSUMED
        }




        val gendersArr = resources.getStringArray(R.array.genders_list)
        viewBinding.rvGendersList.layoutManager = LinearLayoutManager(this)
        gendersAdapter = Adapter()
        gendersAdapter.genders = gendersArr.toList() as ArrayList<String>
        viewBinding.rvGendersList.adapter = gendersAdapter


        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

//        Glide.with(this)
//                .load("https://burlingtonfurniture.us/wp-content/uploads/2021/07/blank-profile-picture-973460_1280-768x768.png")
//                .circleCrop()
//                .into(viewBinding.ivProfilePic)

//        Glide.with(this)
//                .load("https://burlingtonfurniture.us/wp-content/uploads/2021/07/blank-profile-picture-973460_1280-768x768.png")
//                .circleCrop()
//                .into(viewBinding.ivEditImage)
    }
}