package com.example.instagram.helper

import android.app.Activity
import android.content.Context.MODE_PRIVATE

class SharedHelper {
    fun setTheme(activity: Activity,theme:Boolean){
        val pref = activity.getSharedPreferences("myPref",MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("theme",theme)
        editor.apply()
    }
    fun getTheme(activity: Activity): Boolean {
        val pref = activity.getSharedPreferences("myPref", MODE_PRIVATE)
        return pref.getBoolean("theme",false)
    }
}