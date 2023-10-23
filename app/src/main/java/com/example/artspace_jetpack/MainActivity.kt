package com.example.artspace_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace_jetpack.ui.theme.ArtSpace_jetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpace_jetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Art_space()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpace_jetpackTheme {
        Art_space()
    }
}

@Composable
fun Art_space() {
    val image = listOf(
        R.drawable.toto,
        R.drawable.dora,
        R.drawable.cota_,
        R.drawable.shea,
        R.drawable.sheb
    )

    val authorImage = listOf(
        stringResource(id = R.string.author_toto),
        stringResource(id = R.string.author_dora),
        stringResource(id = R.string.author_cotam),
        stringResource(id = R.string.author_shea),
        stringResource(id = R.string.author_sheb)
    )

    val descripImage = listOf(
        stringResource(id = R.string.toto),
        stringResource(id = R.string.dora),
        stringResource(id = R.string.cotam),
        stringResource(id = R.string.shea),
        stringResource(id = R.string.sheb)
    )

    var clickNext by remember { mutableStateOf(0) }
    var clickPre by remember { mutableStateOf(0) }
    var stateImage by remember { mutableStateOf(0) }


    Surface(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(image[stateImage]),
                contentDescription = null,
                modifier = Modifier
                    .height(400.dp)
                    .width(300.dp)
                    .border(
                        BorderStroke(0.5.dp, Color.LightGray)
                    )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier
                    .background(Color.LightGray)
            ) {

                Text(
                    text = descripImage[stateImage],
                    fontStyle = FontStyle.Italic,
                    fontSize = 30.sp
                )
                Text(
                    text = authorImage[stateImage],
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                val buttonModifier = Modifier
                    .height(40.dp)
                    .width(120.dp)
                Button(
                    onClick = {
                        when (clickPre) {
                            0 -> {
                                if (stateImage == 0) {
                                    stateImage = 4
                                } else {
                                    stateImage--
                                }
                            }

                            1 -> {
                                stateImage--
                            }

                            2 -> {
                                stateImage--
                            }

                            3 -> {
                                stateImage--
                            }

                        }
                    },
                    modifier = buttonModifier
                ) {
                    Text(
                        text = "Previous",
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.width(50.dp))

                Button(
                    onClick = {
                        when (clickNext) {
                            0 -> {
                                if (stateImage == 4) {
                                    stateImage = 0
                                } else {
                                    stateImage++
                                }
                            }

                            1 -> {
                                stateImage++
                            }

                            2 -> {
                                stateImage++
                            }

                            3 -> {
                                stateImage++
                            }

                        }
                    },
                    modifier = buttonModifier
                ) {
                    Text(
                        text = "Next",
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }
}








