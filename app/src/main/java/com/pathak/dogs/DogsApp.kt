package com.pathak.dogs

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DogsApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}