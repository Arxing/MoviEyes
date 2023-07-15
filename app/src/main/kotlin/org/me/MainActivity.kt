package org.me

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import org.me.core.shared.Router
import org.me.core.shared.util.ToastUtil
import org.me.databinding.ActivityMainBinding
import org.me.feature.movie_lists.ui.PopularMoviesFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @Inject lateinit var router: Router
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }.root)

    setupBottomNavigation()
  }

  private fun setupBottomNavigation() {
    binding.bottomNavigation.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.page_popular_movies -> {
          true
        }

        R.id.page_favorite -> {
          true
        }

        else -> {
          ToastUtil.show(this, "Coming Soon!")
          false
        }
      }
    }
  }
}
