package com.juntas.juntas_app.preference_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HealthItem(
    checked: Boolean,
    onCheck: () -> Unit,
    onTextChange: (String) -> Unit,
    textValue: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = text, overflow = TextOverflow.Ellipsis)
        Checkbox(
            checked = checked ,
            onCheckedChange = { onCheck() },
            colors = CheckboxDefaults.colors(
                uncheckedColor = MaterialTheme.colorScheme.tertiary
            )
        )
        OutlinedTextField(
            value = textValue ,
            onValueChange = { onTextChange(it) },
            modifier = Modifier.height(55.dp).width(250.dp),
            enabled = checked,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                unfocusedContainerColor = Color.Transparent,
                disabledTextColor = Color.Black,
                focusedTextColor = Color.Black
            ),
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HealthItemPreview() {
    HealthItem(true,{},{},"","Something")
}