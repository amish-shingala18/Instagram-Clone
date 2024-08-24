package com.example.instagram
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.fragment.HomeFragment
import com.example.instagram.fragment.ProfileFragment
import com.example.instagram.fragment.SearchFragment
import com.example.instagram.helper.SharedHelper

class MainActivity : AppCompatActivity() {
    private val helper = SharedHelper()
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val theme = helper.getTheme(this)
        if (theme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            loadFragment(HomeFragment())
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            loadFragment(HomeFragment())
        }
        loadFragment(HomeFragment())
        binding.navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> loadFragment(HomeFragment())
                R.id.search -> loadFragment(SearchFragment())
                R.id.profile -> loadFragment(ProfileFragment())
                else -> loadFragment(HomeFragment())
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container1, fragment)
        fragmentTransaction.commit()
        fragmentTransaction.setReorderingAllowed(false)
    }
}