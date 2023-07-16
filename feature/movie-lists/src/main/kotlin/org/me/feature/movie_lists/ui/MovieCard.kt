package org.me.feature.movie_lists.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import org.me.core.shared.R
import org.me.feature.movie_lists.data.MovieCardState

@Composable
fun MovieCard(
  modifier: Modifier = Modifier,
  state: MovieCardState,
  onClick: () -> Unit,
  onClickFavorite: () -> Unit,
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .height(150.dp)
      .clickable {
        onClick()
      },
    elevation = 5.dp,
  ) {
    Box(modifier = Modifier.fillMaxSize()) {
      Row {
        AsyncImage(
          model = state.coverUrl,
          contentDescription = null,
          imageLoader = LocalContext.current.imageLoader,
        )
        Column(
          modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(vertical = 20.dp),
        ) {
          Text(
            text = state.title,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 14.sp,
          )
          Text(
            text = state.releaseDate,
            fontSize = 10.sp,
            color = colorResource(id = R.color.gray)
          )
          Text(
            modifier = Modifier.padding(top = 10.dp),
            text = state.overview.takeIf { it.isNotEmpty() } ?: "Nothing...",
            overflow = TextOverflow.Ellipsis,
            fontSize = 10.sp,
          )
        }
      }

      IconButton(
        modifier = Modifier
          .size(30.dp)
          .align(Alignment.BottomEnd)
          .padding(5.dp),
        onClick = {
          onClickFavorite()
        }
      ) {
        if (state.isFavorite) {
          Icon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = null,
            tint = Color.Red,
          )
        } else {
          Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = null,
            tint = Color.Gray,
          )
        }
      }
    }
  }
}
