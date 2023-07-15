package org.me.feature.movie_lists.ui

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState.Loading
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.me.core.shared.BaseComposeFragment
import org.me.core.shared.util.ToastUtil
import org.me.feature.movie_lists.viewmodel.PopularMoviesViewModel
import org.me.feature.movie_lists.viewmodel.PopularMoviesViewModel.OnError

@AndroidEntryPoint
class PopularMoviesFragment : BaseComposeFragment() {

  private val viewModel: PopularMoviesViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindViewModel()
  }

  @Composable
  override fun Content() {
    val movieCards = viewModel.getPopularMoviesFlow().collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
      LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
      ) {
        items(items = movieCards) {
          if (it != null) {
            MovieCard(state = it)
          }
        }

        if (movieCards.loadState.refresh is Loading || movieCards.loadState.append is Loading) {
          item {
            Box(
              modifier = Modifier.fillMaxSize(),
              contentAlignment = Alignment.Center,
            ) {
              CircularProgressIndicator()
            }
          }
        }
      }
    }
  }

  private fun bindViewModel() {
    lifecycleScope.launch {
      launch {
        viewModel.events.collect {
          when (it) {
            is OnError -> ToastUtil.show(requireContext(), it.message)
          }
        }
      }
    }
  }

  companion object {

    fun newInstance(): PopularMoviesFragment {
      return PopularMoviesFragment()
    }
  }
}
