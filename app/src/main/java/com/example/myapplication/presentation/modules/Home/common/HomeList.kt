package com.example.myapplication.presentation.modules.Home.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.domain.model.UIHomeModel
import com.example.myapplication.R

@Composable
fun MovieItem(movie: UIHomeModel, onItemClick: (Int) -> Unit) {

    val (showDetail, setShowDetail) = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Surface {
            Row(modifier = Modifier
                .background(colorResource(id = R.color.white))
                .fillMaxWidth()) {
                MovieImage(url = movie.url)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = colorResource(id = R.color.black),
                        maxLines = 5
                    )
                    Text(
                        text = movie.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(id = R.color.black),
                        maxLines = 5
                    )
                    CharacterDetail(character = movie, showDetail = showDetail) {
                        setShowDetail(!showDetail)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

@Composable
fun CharacterDetail(character: UIHomeModel, showDetail: Boolean, onToggleDetail: () -> Unit) {
    if (showDetail) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Status: ${character.status}")
            Text("Species: ${character.species}")
            Text("Type: ${character.type}")
            Text("Gender: ${character.gender}")
            Text("Origin: ${character.origin}")
            Text("Location: ${character.location}")
        }
    }

    // Botón para alternar detalle
    Button(
        onClick = { onToggleDetail() },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(if (showDetail) "Ocultar detalle" else "Ver detalle")
    }

}

@Composable
fun MovieImage(url: String) {
    Box {
        GenericAsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .width(150.dp),
            data = url,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.app_name)
        )
    }

}

@Composable
fun GenericAsyncImage(
    data: Any,
    placeholder: Painter?,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.FillBounds,
    modifier: Modifier,
    size: Dp? = null,
    width: Dp? = null,
    height: Dp? = null
) {
    Box (
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data)
                .crossfade(true)
                .build(),
            placeholder = placeholder,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.fillMaxSize()
        )
    }
}