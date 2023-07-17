package org.me

import android.app.Application
import coil.Coil
import coil.ImageLoader
import dagger.hilt.android.HiltAndroidApp
import org.me.core.data.db.MEDatabase
import javax.inject.Inject

@HiltAndroidApp
class MEApplication : Application() {

  @Inject lateinit var imageLoader: ImageLoader
  @Inject lateinit var meDatabase: MEDatabase

  override fun onCreate() {
    super.onCreate()
    Coil.setImageLoader(imageLoader)
  }
}
