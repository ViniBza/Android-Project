package br.com.fiap.myfirsttask

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title: String,
    val icon: ImageVector,
    var rota: Int,
)
