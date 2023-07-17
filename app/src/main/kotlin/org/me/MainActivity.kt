package org.me

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import dagger.hilt.android.AndroidEntryPoint
import org.me.core.shared.Router
import org.me.databinding.ActivityMainBinding
import org.me.feature.account.ui.FavoriteMoviesFragment
import org.me.feature.movie_lists.ui.PopularMoviesFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @Inject lateinit var router: Router
  private lateinit var binding: ActivityMainBinding

  private val pageMapping = listOf(
    0 to R.id.page_popular_movies,
    1 to R.id.page_favorite,
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }.root)

    setupBottomNavigation()
    setupViewPager()
  }

  private fun setupBottomNavigation() {
    binding.bottomNavigation.setOnNavigationItemSelectedListener {
      binding.viewPager.currentItem = itemIdToPosition(it.itemId)
      true
    }
  }

  private fun setupViewPager() {
    binding.viewPager.adapter = MainPagerAdapter(this)
    binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {

      override fun onPageSelected(position: Int) {
        binding.bottomNavigation.selectedItemId = positionToItemId(position)
      }
    })
  }

  private fun positionToItemId(position: Int): Int = pageMapping.single { it.first == position }.second

  private fun itemIdToPosition(itemId: Int): Int = pageMapping.single { it.second == itemId }.first

  private inner class MainPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = pageMapping.size

    override fun createFragment(position: Int): Fragment {
      return when (positionToItemId(position)) {
        R.id.page_popular_movies -> PopularMoviesFragment.newInstance()
        R.id.page_favorite -> FavoriteMoviesFragment.newInstance()
        else -> TODO()
      }
    }
  }
}
