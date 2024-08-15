package jy.ui.research.simple.button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageButton(
    resource: DrawableResource,
    title: String,
    callback: () -> Unit,
    mod: Modifier
)
{
    Button(
        modifier = mod,
        onClick = callback
        )
    {
        Image(
            painter = painterResource(resource),
            contentDescription = null,
            modifier = Modifier.background(Color(0x00000000))
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 4.dp).background(Color(0x00000000))
        )
    }
}