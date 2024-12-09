package tw.edu.pu.csim.s1120053

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import tw.edu.pu.csim.s1120053.ui.theme.S1120053Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1120053Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                    Start(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Start(modifier: Modifier) {
    val context = LocalContext.current
    var backgroundColor by remember { mutableStateOf(Color(0xff95fe95)) }
    val colors = listOf(
        Color(0xff95fe95),
        Color(0xfffdca0f),
        Color(0xfffea4a4),
        Color(0xffa5dfed)
    )
    var colorIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    var dragDelta = dragAmount
                    val threshold = 50f
                    if (dragDelta > threshold) {
                        colorIndex = (colorIndex + 1) % colors.size
                        backgroundColor = colors[colorIndex]
                        dragDelta = 0f
                    } else if (dragDelta < -threshold) {
                        colorIndex = (colorIndex - 1 + colors.size) % colors.size
                        backgroundColor = colors[colorIndex]
                        dragDelta = 0f
                    }
                }
            }
    ) {
        Column(
//            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "")
            Text(text = "2024期末上機考(資管二B張惠芯)")
            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "B班",
//                modifier = Modifier
//                    .fillMaxSize()
            )
            Text(text = "遊戲持續時間 0 秒")
            Text(text = "您的成績 0 分")
            Button(
                onClick = {(context as? android.app.Activity)?.finish()}
            ) {
                Text(text = "結束APP")
            }
        }
    }
}