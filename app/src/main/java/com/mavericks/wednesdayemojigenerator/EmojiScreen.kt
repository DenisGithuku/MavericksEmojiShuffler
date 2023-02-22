package com.mavericks.wednesdayemojigenerator

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EmojiScreen(
    infoList: List<Pair<String, String>>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2)
    ) {
        items(items = infoList, key = { it.first }) { infoItem ->
            InfoCard(
                info = infoItem,
                modifier = modifier.animateItemPlacement(tween(durationMillis = 300))
            )
        }
    }
}

@Composable
fun InfoCard(
    info: Pair<String, String>,
    modifier: Modifier
) {
    // destructure info pair
    val (emoji, description) = info
    Card(
        modifier = modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // emoji
            Text(
                text = emoji,
                fontSize = 20.sp
            )
            Text(
                text = description,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun InfoCardPreview() {
    InfoCard(info = Pair("\uD83E\uDD13", "Nerd face"), modifier = Modifier)
}