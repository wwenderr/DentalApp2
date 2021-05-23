package com.example.dentalapp3

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dentalapp3.ui.QuitDialogFragment
import com.example.dentalapp3.ui.OnBackPressedListener
import com.example.dentalapp3.ui.second.SecondFragment
import com.example.dentalapp3.ui.first.FirstFragment
import com.example.dentalapp3.ui.first.RewardActivity
import com.example.dentalapp3.ui.third.ThirdFragment
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.main_menu_activity.*
import com.example.dentalapp3.ui.fourth.FourthFragment as FourthFragment


class MainMenuActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        setContentView(R.layout.main_menu_activity)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val fourthFragment = FourthFragment()


        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.fire -> setCurrentFragment(secondFragment)
                R.id.profile -> setCurrentFragment(thirdFragment)
                R.id.reward_icon -> setCurrentFragment(fourthFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        var backPressedListener: OnBackPressedListener? = null
        for (fragment in fm.fragments) {
            if (fragment is OnBackPressedListener) {
                backPressedListener = fragment
                break
            }
        }
        if (backPressedListener != null) {
            backPressedListener.onBackPressed()
        } else {
            openQuitDialog()
        }
    }

    private fun openQuitDialog() {
        val quitDialogFragment = QuitDialogFragment()
        val manager = supportFragmentManager
        quitDialogFragment.show(manager, "dialog")
    }
}
