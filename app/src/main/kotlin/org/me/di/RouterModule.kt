package org.me.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.me.core.shared.Router
import org.me.router.RouterImpl

@Module
@InstallIn(ActivityComponent::class)
internal abstract class RouterModule {

  @Binds
  abstract fun bindRouter(impl: RouterImpl): Router
}
