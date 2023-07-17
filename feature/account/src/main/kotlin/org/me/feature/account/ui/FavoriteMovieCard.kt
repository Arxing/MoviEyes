package org.me.feature.account.ui

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
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import org.me.core.shared.R.drawable
import org.me.feature.account.data.FavoriteMovieCardState

@Composable
fun FavoriteMovieCard(
  modifier: Modifier = Modifier,
  state: FavoriteMovieCardState,
  onClick: () -> Unit,
  onClickDelete: () -> Unit,
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
          error = painterResource(id = drawable.baseline_warning_amber_24),
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
        }
      }

      IconButton(
        modifier = Modifier
          .align(Alignment.BottomEnd)
          .padding(5.dp)
          .size(22.dp),
        onClick = {
          onClickDelete()
        }
      ) {
        Icon(
          imageVector = Icons.Default.Delete,
          contentDescription = null,
          tint = Color.Gray,
        )
      }
    }
  }
}
