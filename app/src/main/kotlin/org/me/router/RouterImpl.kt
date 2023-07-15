package org.me.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import dagger.hilt.android.scopes.ActivityScoped
import org.me.R.id
import org.me.core.shared.Router
import javax.inject.Inject

@ActivityScoped
class RouterImpl @Inject constructor(
  private val activity: FragmentActivity,
) : Router {

  override fun addFragment(fragment: Fragment) {
    activity
      .supportFragmentManager
      .commit {
        setReorderingAllowed(true)
        add(id.container_fragment, fragment)
      }
  }
}
