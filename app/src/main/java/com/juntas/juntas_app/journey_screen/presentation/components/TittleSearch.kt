package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun TittleSearch() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 18.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = stringResource(R.string.search_for_a_driver),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun TittleSearchPreview() {
    TittleSearch()
}