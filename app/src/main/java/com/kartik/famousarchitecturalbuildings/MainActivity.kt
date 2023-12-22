package com.kartik.famousarchitecturalbuildings

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kartik.famousarchitecturalbuildings.ui.theme.FamousArchitecturalBuildingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamousArchitecturalBuildingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArchitectureLayout()
                }
            }
        }
    }
}

@Composable
fun ArchitectureLayout() {
    var currentStep by remember {
        mutableIntStateOf(1)
    }

    Surface {
        when(currentStep){
            1 -> ScreenAll(
                imageId = R.drawable.the_great_wall_of_china_architecture1,
                imageName = "Great Wall of China",
                imageAuthor = "China",
                imageYear = "(1368–1644 AD)",
                onPreviousClick = {
                    currentStep = 8
                },
                onNextClick = {
                    currentStep++
                }
            )
            2 -> ScreenAll(
                imageId = R.drawable.chichen_itza_yucatan_mexico_architecture2,
                imageName = "Chichen Itza",
                imageAuthor = "Mexico",
                imageYear = "(600 AD)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            3 -> ScreenAll(
                imageId = R.drawable.petra_architecture3,
                imageName = "Petra",
                imageAuthor = "Jordan",
                imageYear = "(312 BC)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            4 -> ScreenAll(
                imageId = R.drawable.macchu_picchu_architecture4,
                imageName = "Machu Pichu",
                imageAuthor = "Republic of Peru",
                imageYear = "(1450)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            5 -> ScreenAll(
                imageId = R.drawable.christ_the_redeemer_architecture5,
                imageName = "Christ the Redeemer",
                imageAuthor = "Brazil",
                imageYear = "(1931)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            6 -> ScreenAll(
                imageId = R.drawable.the_colosseum_architecture6,
                imageName = "Colosseum",
                imageAuthor = "Italy",
                imageYear = "(80 AD)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            7 -> ScreenAll(
                imageId = R.drawable.taj_mahal_architecture7,
                imageName = "Taj Mahal",
                imageAuthor = "India",
                imageYear = "(1632-1653)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep++
                }
            )
            8 -> ScreenAll(
                imageId = R.drawable.angkor_wat_architecture8,
                imageName = "Angkor Wat",
                imageAuthor = "Combodia",
                imageYear = "(12th century)",
                onPreviousClick = {
                    currentStep--
                },
                onNextClick = {
                    currentStep = 1
                }
            )
        }
    }

}

@Composable
fun ScreenAll(imageId: Int,imageName:String,imageAuthor:String,imageYear:String,onPreviousClick:()->Unit,onNextClick:()->Unit){
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 10.dp
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .border(
                    BorderStroke(borderWidth, rainbowColorsBrush)
                )
                .padding(borderWidth)
                .clip(RectangleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier
                .background(Color.LightGray)
                .padding(20.dp)
        ){
            Text(
                text = imageName,
                fontSize = 25.sp
            )
            Row {
                Text(
                    text = imageAuthor,
                    fontWeight = FontWeight.Bold
                )
                Text(text = " $imageYear")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = onPreviousClick) {
                Text(text = "  Previous  ")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = onNextClick) {
                Text(text = "    Next    ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArchitecturalPreview() {
    FamousArchitecturalBuildingsTheme {
        ArchitectureLayout()
    }
}