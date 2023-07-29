package com.example.designpatterns.dependencyInjection

import android.content.SharedPreferences

import javax.inject.Inject

class MySharedPreferences @Inject constructor(private val mSharedPreferences: SharedPreferences) {
    fun putData(key: String?, data: String?) {
        mSharedPreferences.edit().putString(key, data).apply()
    }

    fun getData(key: String?): String? {
        return mSharedPreferences.getString(key, "Nothing")
    }
}