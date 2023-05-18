package com.roynaldi19.gd1_05devbyterepository

import android.app.Application
import timber.log.Timber

class DevByteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
