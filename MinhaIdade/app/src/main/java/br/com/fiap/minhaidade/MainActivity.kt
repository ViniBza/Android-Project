package br.com.fiap.minhaidade

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.mutableMapOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            meuComponente()

           /* MinhaIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            */
        }
    }
}

@Composable
fun meuComponente(modifier: Modifier = Modifier) {
    val idade = remember { mutableIntStateOf(0) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Spacer(modifier.height(20.dp))
        Text(
            text = "Qual é o sua idade?",
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Center,
           // modifier = Modifier.fillMaxWidth()
            )

        Spacer(modifier.height(20.dp))
        Text(
            text = "Precione os botão abaixo para informar a sua idade." ,
            color = Color.Blue,
            fontSize = 18.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier.height(20.dp))
        Text(
            text = "${idade.value}" ,
            color = Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Button(
                onClick = {
                    idade.value++
                    Log.i("FIAP", "${idade.value}")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red) ) {
                Text("+")
            }

        Spacer(modifier.width(20.dp))

            Button(onClick = { idade.value -- },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))) {
                Text("-")
            }

        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun meuComponentePreview( ) {
    meuComponente()
}