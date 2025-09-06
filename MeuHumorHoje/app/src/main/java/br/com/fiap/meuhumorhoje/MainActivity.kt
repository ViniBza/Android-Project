package br.com.fiap.meuhumorhoje

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.meuhumorhoje.ui.theme.MeuHumorHojeTheme
import org.intellij.lang.annotations.JdkConstants

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
    var visibily by remember {
        mutableStateOf(false)
    }
    Box(
    )  {
        Column(modifier = modifier.fillMaxSize()){

        Spacer( modifier = Modifier.height(TopPadding))

        Text(
            text = "Meu Humor Hoje",
            fontSize = 35.sp,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

         Spacer( modifier = Modifier.height(TopPadding))

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

            OutlinedButton(onClick = { /*TODO*/ }) {
                Text( text = "-")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text( text = "+")
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
               text = "Seu número é: ",
               fontSize = 16.sp,
               style = MaterialTheme.typography.displaySmall,
               )

           Spacer(modifier = Modifier.height(TopPadding))

           ElevatedButton(onClick ={visibily = !visibily} ) {
               Text( text = "Verificar seu humor")
           }
           
           Spacer(modifier = Modifier.height(TopPadding))

           AnimatedVisibility(visible = visibily) {
                Text(
                    text = "OLA MUNDO!!!!!!!",
                    fontSize = 16.sp,
                )
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