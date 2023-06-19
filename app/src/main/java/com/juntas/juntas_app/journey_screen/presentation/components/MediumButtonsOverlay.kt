package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mode
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun MediumButtonsOverlay(
    complete: Boolean,
    icon: ImageVector,
    buttonText: String,
    buttonWidth: Dp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonColor = if (complete) ButtonDefaults.buttonColors(
        containerColor = Color(0xFF5CBA2A),
        contentColor = Color.White
    )
    else ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color(0xFF5CBA2A)
    )
    val textColor = if (complete) Color.White else MaterialTheme.colorScheme.onBackground

    Button(
        onClick = { onClick() },
        modifier = modifier
            .width(buttonWidth)
            .height(44.dp),
        shape = RoundedCornerShape(10.dp),
        colors = buttonColor,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 2.dp,
            focusedElevation = 10.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Calendar icon"
            )
            Text(
                text = buttonText,
                style = MaterialTheme.typography.titleSmall,
                color = textColor,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                painterResource(id = R.drawable.forward_arrow_icon),
                contentDescription = "Forward arrow"
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MediumButtonsOverlayPreview() {
    MediumButtonsOverlay( false, Icons.Default.Mode,"Where ", 100.dp, {})
}