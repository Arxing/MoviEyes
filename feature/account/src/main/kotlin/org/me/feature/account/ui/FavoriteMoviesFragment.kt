package org.me.feature.account.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.me.core.shared.BaseComposeFragment
import org.me.core.shared.Router
import org.me.feature.account.R
import org.me.feature.account.viewmodel.FavoriteMoviesViewModel
import org.me.feature.movie_lists.ui.MovieDetailFragment
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMoviesFragment private constructor() : BaseComposeFragment() {
  private val viewModel: FavoriteMoviesViewModel by viewModels()

  @Inject lateinit var router: Router

  @OptIn(ExperimentalFoundationApi::class)
  @Composable
  override fun Content() {
    val lazyListState = rememberLazyListState()
    val movieCards by viewModel.movieCards.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
      if (movieCards.isNotEmpty()) {
        LazyColumn(
          verticalArrangement = Arrangement.spacedBy(15.dp),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
          state = lazyListState,
        ) {
          items(items = movieCards) {
            FavoriteMovieCard(
              modifier = Modifier.animateItemPlacement(),
              state = it,
              onClick = {
                router.addFragment(MovieDetailFragment.newInstance(it.movieId))
              },
              onClickDelete = {
                viewModel.deleteFavorite(it)
              }
            )
          }
        }
      }

      AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        visible = movieCards.isEmpty(),
        enter = fadeIn(),
      ) {
        Column(
          modifier = Modifier.align(Alignment.Center),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Icon(
            imageVector = Icons.Filled.Face,
            contentDescription = null,
            tint = colorResource(id = org.me.core.shared.R.color.gray),
          )
          Text(
            text = "還沒有任何最愛",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            color = colorResource(id = org.me.core.shared.R.color.gray),
          )
        }
      }
    }
  }

  @Composable
  private fun DeleteDialog(onDismissRequest: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
      onDismissRequest = onDismissRequest,
      title = {
        Text(text = "刪除我的最愛")
      },
      text = {
        Text(text = "確定要刪除嗎?")
      },
      confirmButton = {
        Button(
          onClick = onConfirm,
        ) {
          Text(text = "是")
        }
      }
    )
  }

  companion object {

    fun newInstance(): FavoriteMoviesFragment {
      return FavoriteMoviesFragment()
    }
  }
}
