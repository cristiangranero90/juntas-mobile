package com.juntas.juntas_app.journey_screen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JourneyScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar({/*TODO: Set clicked functions */}, {}, "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg") } ,
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .height(136.dp)
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.main_women),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(2.dp)),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 26.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(R.string.where_you),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                )
                Text(
                    text = stringResource(R.string.want_to_go),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun JourneyScreenPreview() {
    JourneyScreen()
}
