package com.mavericks.wednesdayemojigenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mavericks.wednesdayemojigenerator.ui.theme.WednesdayEmojiGeneratorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var emojiItems = remember {
                listOf(
                    Pair("\uD83D\uDE10", "Neutral face"),
                    Pair("\uD83D\uDE2C", "Grimacing face"),
                    Pair("\uD83E\uDD10", "Zipper mouth"),
                    Pair("\uD83D\uDC35", "Monkey face"),
                    Pair("\uD83E\uDD74", "Woozy"),
                    Pair("\uD83E\uDD25", "Lying face"),
                    Pair("\uD83E\uDD76", "Cold face"),
                    Pair("\uD83E\uDD20", "Cowboy face"),
                    Pair("\uD83D\uDCA5", "Collision"),
                    Pair("\uD83D\uDCAF", "Hundred points"),
                    Pair("\uD83D\uDCAC", "Speech balloon"),
                )
            }

            var randomizedEmojiItems = remember {
                mutableStateOf(emojiItems)
            }

            WednesdayEmojiGeneratorTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                // generate random count from list, with 1 as the least number
                                val randomEmojiItemCount = (1..emojiItems.size).random()

                                // reassign state to emoji screen with the random count
                                randomizedEmojiItems.value = emojiItems.take(randomEmojiItemCount).shuffled()

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Refresh,
                                contentDescription = "Refresh"
                            )
                        }
                    }
                ) { paddingValues ->
                    EmojiScreen(infoList = randomizedEmojiItems.value, modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
