package org.me.feature.movie_lists.ui

import android.os.Bundle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.me.core.shared.BaseComposeFragment
import org.me.core.shared.R
import org.me.core.shared.util.ToastUtil
import org.me.feature.movie_lists.viewmodel.MovieDetailViewModel
import org.me.feature.movie_lists.viewmodel.MovieDetailViewModel.OnError
import kotlin.math.roundToInt

@AndroidEntryPoint
class MovieDetailFragment private constructor() : BaseComposeFragment() {
  private val viewModel: MovieDetailViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    bindViewModel()
    viewModel.fetchMovie(requireArguments().getInt(ARGS_MOVIE_ID))
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

  @Composable
  override fun Content() {
    val screen = viewModel.screen

    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary)
        .verticalScroll(rememberScrollState())
        .padding(bottom = 15.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Cover(
        coverUrl = screen.coverUrl,
        backdropUrl = screen.backdropUrl,
        isFavorite = viewModel.isFavorite,
        onClickFavorite = {
          viewModel.toggleFavorite()
        },
      )
      Title(title = screen.title)
      AverageRate(voteAverage = screen.voteAverage)
      Description(releaseDate = screen.releaseDate, genres = screen.genres)
      Overview(overview = screen.overview)
    }
  }

  @Composable
  private fun Cover(coverUrl: String, backdropUrl: String, isFavorite: Boolean, onClickFavorite: () -> Unit) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
    ) {
      AsyncImage(
        modifier = Modifier.fillMaxSize(),
        model = backdropUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        error = painterResource(id = R.drawable.baseline_warning_amber_24),
      )
      Card(
        modifier = Modifier.padding(20.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.gray_light))
      ) {
        AsyncImage(
          model = coverUrl,
          contentDescription = null,
          error = painterResource(id = R.drawable.baseline_warning_amber_24),
        )
      }
      FavoriteButton(
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .padding(10.dp)
          .size(22.dp),
        isFavorite = isFavorite,
        onClick = onClickFavorite,
      )
    }
  }

  @Composable
  private fun FavoriteButton(modifier: Modifier, isFavorite: Boolean, onClick: () -> Unit) {
    IconButton(
      modifier = modifier,
      onClick = onClick,
    ) {
      if (isFavorite) {
        Icon(
          imageVector = Outlined.Favorite,
          contentDescription = null,
          tint = Color.Red,
        )
      } else {
        Icon(
          imageVector = Outlined.FavoriteBorder,
          contentDescription = null,
          tint = Color.Gray,
        )
      }
    }
  }

  @Composable
  private fun Title(title: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
      Text(
        modifier = Modifier.align(Alignment.Center),
        text = title,
        color = MaterialTheme.colors.onSecondary,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
      )
    }
  }

  @Composable
  private fun AverageRate(voteAverage: Float) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      RateProgress(rate = voteAverage)
      Text(
        modifier = Modifier.padding(start = 10.dp),
        text = "平均評分",
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onSecondary,
      )
    }
  }

  @Composable
  private fun RateProgress(rate: Float) {
    Box {
      CircularProgressIndicator(
        progress = rate,
        backgroundColor = colorResource(id = R.color.gray_light),
      )
      Row(modifier = Modifier.align(Alignment.Center)) {
        val rateInt = rate.times(100).roundToInt()
        Text(
          modifier = Modifier.alignByBaseline(),
          text = rateInt.toString(),
          fontWeight = FontWeight.Bold,
          fontSize = 16.sp,
          color = MaterialTheme.colors.onSecondary,
        )
        Text(
          modifier = Modifier.alignByBaseline(),
          text = "%",
          fontSize = 10.sp,
          color = MaterialTheme.colors.onSecondary,
        )
      }
    }
  }

  @Composable
  private fun Description(releaseDate: String, genres: List<String>) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.secondaryVariant)
        .padding(vertical = 5.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        text = releaseDate,
        color = MaterialTheme.colors.onSecondary,
      )
      Text(
        text = genres.joinToString(", "),
        color = MaterialTheme.colors.onSecondary,
      )
    }
  }

  @Composable
  private fun Overview(overview: String) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
    ) {
      Text(
        modifier = Modifier.align(Alignment.Start),
        text = "概要",
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        color = MaterialTheme.colors.onSecondary,
      )
      Text(
        modifier = Modifier.padding(top = 5.dp),
        text = overview,
        color = MaterialTheme.colors.onSecondary,
        letterSpacing = 1.sp,
        lineHeight = 22.sp,
      )
    }
  }

  companion object {
    const val ARGS_MOVIE_ID = "args-movie-id"

    fun newInstance(movieId: Int): MovieDetailFragment {
      return MovieDetailFragment().apply {
        arguments = bundleOf(ARGS_MOVIE_ID to movieId)
      }
    }
  }
}
