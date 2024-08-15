package jy.ui.research

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
// import androidx.compose.animation.Sh
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jy.ui.research.core.StyleHelper
import jy.ui.research.simple.button.ImageButton
import uiresearch.composeapp.generated.resources.Res
import uiresearch.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val navController = rememberNavController()

        Column()
        {
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .padding(start = 4.dp, end = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            )
            {
                ImageButton(
                    resource = Res.drawable.compose_multiplatform,
                    title = "Page 1asdasdasdasdasdas",
                    callback = {
                        navController.navigate("title")
                    },
                    mod = Modifier.background(Color(0xFF00FF00))
                )
                ImageButton(
                    resource = Res.drawable.compose_multiplatform,
                    title = "Page 1",
                    callback = {
                        navController.navigate("body")
                    },
                    mod = Modifier.background(Color(0xFF00FF00))
                )
            }
            NavHost(
                navController,
                startDestination = "title",
                modifier = Modifier.
                fillMaxSize().
                background(Color(0xFF00FF00))
            )
            {
                composable(route = "title")
                {
                    Text(text = "Test Text!!")
                }
                composable(route = "body")
                {
                    Box(modifier = Modifier.background(Color(0xFF00FFFF)))
                    {

                    }
                }
            }
//            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
//                AnimatedVisibility(showContent) {
//                    val greeting = remember { Greeting().greet() }
//                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                        Image(painterResource(Res.drawable.compose_multiplatform), null)
//                        Text("Compose: $greeting")
//                    }
//                }
//            }
        }
    }
}