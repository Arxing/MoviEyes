package org.me.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import dagger.hilt.android.scopes.ActivityScoped
import org.me.R
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
        setCustomAnimations(R.anim.slide_in, R.anim.fragment_hide, 0, R.anim.slide_out)
        val tag = fragment.javaClass.name
        addToBackStack(tag)
        add(id.container_fragment, fragment, tag)
      }
  }
}
