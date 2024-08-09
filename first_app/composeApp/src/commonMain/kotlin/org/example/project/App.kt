package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import first_app.composeapp.generated.resources.Res
import first_app.composeapp.generated.resources.compose_multiplatform
import first_app.composeapp.generated.resources.*
import kotlinx.datetime.*
import org.jetbrains.compose.resources.DrawableResource


/**
 * App()
 * - @composable로 어노테이트된 정규 코틀린 함수
 * - Composable function 또는 composables 라고 불림
 *
 * composable function은 다음과 같은 기능을 갖음
 * - MaterialTheme: application의 디자인을 담당
 * - Column: layout
 * - AnimatedVisibility: 애니메이션을 이용해 이미지를 보이거나 숨김
 * - painterResource: XML resource에 저장된 벡터 아이콘을 불러옴
 *
 * 상태 관리하기
 * - var showContent by remember { mutableStateOf(false) }
 * -- mutableStateOf: 관측 가능한 상태를 선언
 * -- remember: 상태를 한 번만 생성, framework에서 관리
 */

//fun todaysDate(): String {
//    fun LocalDateTime.format() = toString().substringBefore('T')
//
//    val now = Clock.System.now()
//    val zone = TimeZone.currentSystemDefault()
//    return now.toLocalDateTime(zone).format()
//}
//
//@Composable
//@Preview
//fun App() {
//
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        val greeting = remember{Greeting().greet()}
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(
//                text = "Today's date is ${todaysDate()}",
//                modifier = Modifier.padding(20.dp),
//                fontSize = 24.sp,
//                textAlign = TextAlign.Center
//            )
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}

//data class Country(val name: String, val zone: TimeZone, val image: DrawableResource)
//
//fun currentTimeAt(location: String, zone: TimeZone): String {
//    fun LocalTime.formatted() = "$hour:$minute:$second"
//
//    val time = Clock.System.now()
//    val localTime = time.toLocalDateTime(zone).time
//
//    return "The time in $location is ${localTime.formatted()}"
//}
//
//val defaultCountries = listOf(
//    Country("Japan", TimeZone.of("Asia/Tokyo"), Res.drawable.jp),
//    Country("France", TimeZone.of("Europe/Paris"), Res.drawable.fr),
//    Country("Mexico", TimeZone.of("America/Mexico_City"), Res.drawable.mx),
//    Country("Indonesia", TimeZone.of("Asia/Jakarta"), Res.drawable.id),
//    Country("Egypt", TimeZone.of("Africa/Cairo"), Res.drawable.eg)
//)
//
//@Composable
//@Preview
//fun App(countries: List<Country> = defaultCountries) {
//    MaterialTheme {
//        var showCountries by remember { mutableStateOf(false) }
//        var timeAtLocation by remember { mutableStateOf("No location selected") }
//
//        Column(modifier = Modifier.padding(20.dp)) {
//            Text(
//                timeAtLocation,
//                style = TextStyle(fontSize = 20.sp),
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
//            )
//            Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
//                DropdownMenu(
//                    expanded = showCountries,
//                    onDismissRequest = { showCountries = false }
//                ) {
//                    countries.forEach { (name, zone, image) ->
//                        DropdownMenuItem(
//                            onClick = {
//                                timeAtLocation = currentTimeAt(name, zone)
//                                showCountries = false
//                            }
//                        ) {
//                            Row(verticalAlignment = Alignment.CenterVertically) {
//                                Image(
//                                    painterResource(image),
//                                    modifier = Modifier.size(50.dp).padding(end = 10.dp),
//                                    contentDescription = "$name flag"
//                                )
//                                Text(name)
//                            }
//                        }
//                    }
//                }
//            }
//
//            Button(modifier = Modifier.padding(start = 20.dp, top = 10.dp),
//                onClick = { showCountries = !showCountries }) {
//                Text("Select Location")
//            }
//        }
//    }
//}

fun greet(): String {
    return Greeting().greeting()
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        )
        {
            Column(
                horizontalAlignment = Alignment.Start,
            )
            {
                Text(greet(), Modifier.padding(8.dp))
                var firstNumber by rememberSaveable { mutableStateOf("") }
                var secondNumber by rememberSaveable { mutableStateOf("") }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    TextField(
                        value = firstNumber,
                        onValueChange = { firstNumber = it },
                        modifier = Modifier.weight(2f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    Text(text = "+", modifier = Modifier.padding(4.dp))
                    TextField(
                        value = secondNumber,
                        onValueChange = { secondNumber = it },
                        modifier = Modifier.weight(2f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )

                    val first = firstNumber.toIntOrNull()
                    val second = secondNumber.toIntOrNull()
                    Text(
                        text = if (first != null && second != null) {
                            "= ${first + second}"
                        } else {
                            "= \uD83E\uDD14"
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}