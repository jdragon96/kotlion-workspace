package org.example.project

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

//fun main() = application {
//    Window(
//        onCloseRequest = ::exitApplication,
//        title = "first_app",
//    ) {
//        App()
//    }
//}
fun main() = application {
    val state = rememberWindowState(
        size = DpSize(400.dp, 250.dp),
        position = WindowPosition(300.dp, 300.dp)
    )
    Window(title = "Local Time App", onCloseRequest = ::exitApplication, state = state) {
        App()
    }
}