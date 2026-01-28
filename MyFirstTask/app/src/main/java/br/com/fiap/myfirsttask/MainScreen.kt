package br.com.fiap.myfirsttask

import android.R.attr.onClick
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.fiap.myfirsttask.ui.theme.pages.HomePage
import br.com.fiap.myfirsttask.ui.theme.pages.NotificationPage
import br.com.fiap.myfirsttask.ui.theme.pages.SettingPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
// Configuração da Navigation Bar
    val NavItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Notification", Icons.Default.Notifications, 2),
        NavItem("Settings", Icons.Default.Settings, 3),
    )

/* Configuracao NavController e NavHost
    //  val navController = rememberNavController() //  1 - gerencia a navegacao
      NavHost(
        navController = navController, // Definindo quem é o controlador de navegação.
        startDestination = NavItemList[selectedIndex].title // 2 - define a tela inicial


 */

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(modifier = Modifier.fillMaxSize(),

        //TOPBAR
        topBar = {
            CenterAlignedTopAppBar( // Deixar a barra centralizada
                colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary ),
                title = {
                Text(text = "My First Task 😉")
            })
        },

        //NAVBAR
        bottomBar = {
           NavigationBar() { NavItemList.forEachIndexed { index, navItem ->
               NavigationBarItem(
               selected = index == selectedIndex,
               onClick = { selectedIndex = index},
               icon = { Icon(imageVector = navItem.icon, contentDescription = " icon ") },
               label = { Text(text = navItem.title) },
               )
           }}
        },
        floatingActionButton = {
            SmallFloatingActionButton (onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    )


    {
        innerPadding ->
        ContentScreen(modifier = modifier
            .padding(innerPadding)
            .fillMaxSize(), selectedIndex = selectedIndex)

    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> HomePage()
        1 -> NotificationPage()
        2 -> SettingPage()
    }

}
