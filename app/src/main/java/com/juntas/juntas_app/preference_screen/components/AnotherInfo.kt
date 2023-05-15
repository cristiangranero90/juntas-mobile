package com.juntas.juntas_app.preference_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun AnotherInfo(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Column(
            modifier = Modifier.width(120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = stringResource(R.string.another_info))
            Text(text = stringResource(R.string.information))
        }
        //Spacer(modifier = Modifier.width(30.dp))
        OutlinedTextField(
            value = text ,
            onValueChange = { onTextChange(it) },
            modifier = Modifier
                .height(55.dp)
                .width(250.dp),
            enabled = true,
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
fun AnotherInfoPreview() {
    AnotherInfo("", {})
}