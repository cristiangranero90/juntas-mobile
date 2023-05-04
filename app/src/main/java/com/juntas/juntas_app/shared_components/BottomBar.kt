package com.juntas.juntas_app.shared_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
) {
    val iconsColor = MaterialTheme.colorScheme.onSurface

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 1.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(R.string.go_to_home),
                    tint = iconsColor
                )},
            alwaysShowLabel = true,
            label = { Text(text = stringResource(R.string.home))}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.world_pink),
                    contentDescription = stringResource(R.string.passenger_item),
                    tint = iconsColor
                        )},
            alwaysShowLabel = true,
            label = { Text(text = stringResource(R.string.passenger))}
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.car_pink),
                    contentDescription = stringResource(R.string.driver_item),
                    tint = iconsColor
                        )},
            alwaysShowLabel = true,
            label = { Text(text = stringResource(R.string.driver))}
        )
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BottomBarPreview() {
    BottomBar()
}