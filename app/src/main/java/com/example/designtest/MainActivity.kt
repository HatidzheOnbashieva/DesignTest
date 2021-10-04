package com.example.designtest

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var gendersAdapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)



        this.window.apply {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //to go FULL_SCREEN on api 30 and above ===> setDecorFitsSystemWindows(false)
                WindowCompat.setDecorFitsSystemWindows(
                    window,
                    false
                )   //tell the window that we want to handle/fit any system windows; the default value is true
//                //т.е по този начин се заема целият екран и сe задействат insets.top and insets.bottom
                WindowCompat.getInsetsController(
                    window,
                    window.decorView
                )?.isAppearanceLightStatusBars = true //sets the foreground colors of the status bar to light so that the items on the bar can be read
                //променя се цветът на иконките на статус бар-а от бяло на по-тъмен цвят, за да не се смесват със светъл/бял фон(в случая)
            } else {
                WindowCompat.setDecorFitsSystemWindows(window, false)
            }
            statusBarColor = Color.TRANSPARENT
            //задължително трябва да сетнем прозрачен цвят на статус бар-а иначе си остава цветът по подразбиране
        }

        ViewCompat.setOnApplyWindowInsetsListener(viewBinding.vView) { view, windowInsets ->
//            On API 21+
//            val navigationBarHeight = WindowInsetsCompat.toWindowInsetsCompat(insets).getInsets(WindowInsetsCompat.Type.navigationBars()).bottom

//            On API 29+
            //getInsets() -> returns visible insets for given types
            //в случая връщаме insets за system bars, които вкл status bar and navigation bar
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            val params: ViewGroup.MarginLayoutParams =
                view.layoutParams as ViewGroup.MarginLayoutParams
            //по този начин задаваме vView да ни е под статус бар-а и над бар-а за навигация
            params.topMargin = insets.top
            params.bottomMargin = insets.bottom
            view.layoutParams = params

            // Return CONSUMED if you don't want want the window insets to keep being
            // passed down to descendant views.
//           The application should return this instance once it has taken care of all insets on a certain level in the view
//           hierarchy, and doesn't need to dispatch to its children anymore for better performance.
            WindowInsetsCompat.CONSUMED
        }

        val gendersArr = resources.getStringArray(R.array.genders_list)
        viewBinding.rvGendersList.layoutManager = LinearLayoutManager(this)
        gendersAdapter = Adapter()
        gendersAdapter.genders = gendersArr.toList() as ArrayList<String>
        viewBinding.rvGendersList.adapter = gendersAdapter

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