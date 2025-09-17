package br.com.fiap.meuhumorhoje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.meuhumorhoje.ui.theme.MeuHumorHojeTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuHumorHojeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val TopPadding = 20.dp
@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val numeroHumor =  remember { mutableIntStateOf(0) }

    var visibily by remember {
        mutableStateOf(false)

    }
    Box(
    )  {
        Column(modifier = modifier.fillMaxSize()){

        Spacer( modifier = Modifier.height(TopPadding) )

        Text(
            text = "Meu Humor Hoje",
            fontSize = 35.sp,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

         Spacer( modifier = Modifier.height(TopPadding) )

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround ) {

            Text(
                text = "Triste",
                fontSize = 20.sp
            )
            Text(
                text = "Feliz",
                fontSize = 20.sp
            )
        }

        Row ( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {

            OutlinedButton(onClick = { numeroHumor.value-- }) {
                Text( text = "-")
            }
            OutlinedButton(onClick = { numeroHumor.value++ }) {
                Text( text = "+" )
            }
        }

       Column (modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
           Text(
               text = "Selecione um número de 0 a 10.",
               fontSize = 18.sp,
               style = MaterialTheme.typography.displaySmall
           )

           Spacer(modifier = Modifier.height(TopPadding))

           Text(
               buildAnnotatedString {
                   append("Sua idade é: ")
                   withStyle(style = SpanStyle(color = Color.Red)) { append("${numeroHumor.value}") }
               }
           )

           Spacer(modifier = Modifier.height(TopPadding))

           ElevatedButton(onClick = {visibily = !visibily} ) {
               Text( text = "Verificar seu humor")
           }
           
           Spacer(modifier = Modifier.height(TopPadding))

           AnimatedVisibility(visible = visibily) {

               when (numeroHumor.value) {

                   in 0..4 ->
                       Image(
                           painterResource(R.drawable.emoticon_dead),
                           contentDescription = "Triste",
                           modifier = Modifier.align(Alignment.CenterHorizontally)
                       )
                   in 5..8 ->
                       Image(
                           painterResource(R.drawable.emoticon_neutral),
                           contentDescription = "Feliz",
                           modifier = Modifier.align(Alignment.CenterHorizontally)
                       )

                   else ->
                       Image(
                           painterResource(R.drawable.emoticon_cool),
                           contentDescription = "Normal",
                           modifier = Modifier.align(Alignment.CenterHorizontally)
                       )

               }
               }

       }
     }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MeuHumorHojeTheme {
        Greeting()

    }
}