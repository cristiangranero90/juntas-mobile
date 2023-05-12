package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun PassengersIncrement(
    number: Int,
    onMinus: () -> Unit,
    onPlus: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HomeFilterSettingsButton(onClick = onMinus, icon = Icons.Default.KeyboardArrowDown)
        Text(text = "$number")
        HomeFilterSettingsButton(onClick = onPlus, icon = Icons.Default.KeyboardArrowUp)
    }
}

@Composable
fun HomeFilterSettingsButton(
    onClick: () -> Unit ,
    icon: ImageVector? ,
    modifier: Modifier = Modifier
){
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults
            .outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(0.dp) ,
        modifier = modifier.size(20.dp)
        //defaultMinSize(ButtonDefaults.MinHeight, ButtonDefaults.MinHeight)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon ,
                contentDescription = "Icon",
                tint = MaterialTheme.colorScheme.onPrimary)
        }
    }
}