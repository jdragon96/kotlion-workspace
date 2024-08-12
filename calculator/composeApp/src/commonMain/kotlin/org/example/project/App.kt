package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import calculator.composeapp.generated.resources.Res
import calculator.composeapp.generated.resources.compose_multiplatform
import calculator.composeapp.generated.resources.*
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
fun greet(): String {
    return Greeting().greeting()
}

fun callName(name: String)
{
    println("My name is ${name}")
}

//@Composable
//@Preview
//fun App() {
//    MaterialTheme {
//        Box(
//            modifier = Modifier.fillMaxWidth(),
//            contentAlignment = Alignment.Center
//        )
//        {
//            Column(
//                horizontalAlignment = Alignment.Start,
//            )
//            {
//                Text(greet(), Modifier.padding(8.dp))
//                var firstNumber by rememberSaveable { mutableStateOf("") }
//                var secondNumber by rememberSaveable { mutableStateOf("") }
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
//                ) {
//                    TextField(
//                        value = firstNumber,
//                        onValueChange = { firstNumber = it },
//                        modifier = Modifier.weight(2f),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    )
//                    Text(text = "+", modifier = Modifier.padding(4.dp))
//                    TextField(
//                        value = secondNumber,
//                        onValueChange = { secondNumber = it },
//                        modifier = Modifier.weight(2f),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    )
//
//                    val first = firstNumber.toIntOrNull()
//                    val second = secondNumber.toIntOrNull()
//                    Text(
//                        text = if (first != null && second != null) {
//                            "= ${first + second}"
//                        } else {
//                            "= \uD83E\uDD14"
//                        },
//                        modifier = Modifier.weight(1f)
//                    )
//                }
//                Button(
//                    onClick = {callName("Test")})
//                {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                    )
//                    {
//                        Image(
//                            painterResource(Res.drawable.eg),
//                            modifier = Modifier.weight(1f),
//                            contentDescription = "Button Icon"
//                        )
//                        Text(
//                            text = "Test Button",
//                            modifier = Modifier.weight(2f),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

enum class OperatorType
{
    NONE, PLUS, MINUS, MULTIPLY, DIVIDE
}

fun changeNumber(num: Pair<String, String>, op: OperatorType, newNum: String): Pair<String, String>
{
    if(op == OperatorType.NONE)
        return Pair<String, String>(num.first + newNum, num.second)
    else
        return Pair<String, String>(num.first, num.second + newNum)
}

fun Calculate(num: Pair<String, String>, op: OperatorType): Double
{
    if(num.first.isEmpty() || num.second.isEmpty())
        return 0.0
    val n1 = num.first.toDouble()
    val n2 = num.second.toDouble()
    when(op)
    {
        OperatorType.PLUS -> {
            return n1 + n2
        }
        OperatorType.MINUS -> {
            return n1 - n2
        }
        OperatorType.MULTIPLY -> {
            return n1 * n2
        }
        OperatorType.DIVIDE -> {
            if(n2 == 0.0)
                return 0.0
            return n1 / n2
        }
        else -> {
            return 0.0
        }
    }
}

@Composable
@Preview
fun App() {
    var CurrentValue: Double by remember { mutableStateOf(0.0) }
    var numbers: Pair<String, String> by remember  { mutableStateOf(Pair<String, String>("", ""))}
    var operator: OperatorType by remember  { mutableStateOf(OperatorType.NONE)}

    MaterialTheme {
        Box(
            modifier = Modifier.padding(12.dp)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize().background(
                    color = Color(0xFF555555),
                    shape = RectangleShape))
            {
                Text(
                    text = CurrentValue.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = numbers.first.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = numbers.second.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = operator.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                )
                {
                    Button(onClick = {numbers = changeNumber(numbers, operator, "7")},
                        modifier = Modifier.weight(1f)
                    )  { Text(text = "7") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "8")},
                        modifier = Modifier.weight(1f))  { Text(text = "8") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "9")},
                        modifier = Modifier.weight(1f))  { Text(text = "9") }
                    Button(onClick = {operator = OperatorType.MULTIPLY},
                        modifier = Modifier.weight(1f))  { Text(text = "*") }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp))
                {
                    Button(onClick = {numbers = changeNumber(numbers, operator, "4")},
                        modifier = Modifier.weight(1f))  { Text(text = "4") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "5")},
                        modifier = Modifier.weight(1f))  { Text(text = "5") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "6")},
                        modifier = Modifier.weight(1f))  { Text(text = "6") }
                    Button(onClick = {operator = OperatorType.DIVIDE},
                        modifier = Modifier.weight(1f))  { Text(text = "/") }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp))
                {
                    Button(onClick = {numbers = changeNumber(numbers, operator, "1")},
                        modifier = Modifier.weight(1f))  { Text(text = "1") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "2")},
                        modifier = Modifier.weight(1f))  { Text(text = "2") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "3")},
                        modifier = Modifier.weight(1f))  { Text(text = "3") }
                    Button(onClick = {operator = OperatorType.PLUS},
                        modifier = Modifier.weight(1f))  { Text(text = "+") }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp))
                {
                    Button(onClick = {
                        println("Before => First : ${numbers.first} ... Second: ${numbers.second}")
                        CurrentValue = Calculate(numbers, operator)
                        numbers = Pair<String, String>(CurrentValue.toString(), "")
                        operator = OperatorType.NONE
                        println("After => First : ${numbers.first} ... Second: ${numbers.second}")
                        },
                        modifier = Modifier.weight(1f))  { Text(text = "=") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, "0")},
                        modifier = Modifier.weight(1f))  { Text(text = "0") }
                    Button(onClick = {numbers = changeNumber(numbers, operator, ".")},
                        modifier = Modifier.weight(1f))  { Text(text = ".") }
                    Button(onClick = {operator = OperatorType.MINUS},
                        modifier = Modifier.weight(1f))  { Text(text = "-") }
                }
            }
        }
    }
}