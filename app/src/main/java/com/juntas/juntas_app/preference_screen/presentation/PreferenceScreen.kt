package com.juntas.juntas_app.preference_screen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.juntas.juntas_app.R
import com.juntas.juntas_app.preference_screen.PreferenceViewModel
import com.juntas.juntas_app.preference_screen.components.AnotherInfo
import com.juntas.juntas_app.preference_screen.components.HealthItem
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@Composable
fun PreferenceScreen(
    onBackClicked: () -> Unit,
    viewModel: PreferenceViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar(
            onProfileClicked = { /*TODO*/ } ,
            onNotificationsClicked = { /*TODO*/ } ,
            imageUrl = "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg"
        )},
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding() ,
                    bottom = paddingValues.calculateBottomPadding() ,
                    start = 10.dp ,
                    end = 10.dp
                )
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack ,
                            contentDescription = "Go back",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = stringResource(R.string.my_preferences),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
            item {
                Column(
                    modifier.width(300.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = stringResource(R.string.smokers_accepted))
                        Spacer(modifier = Modifier.width(30.dp))
                        Checkbox(checked = state.smokers , onCheckedChange = { viewModel.changeSmoker()} )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = stringResource(R.string.pet_friendly))
                        Spacer(modifier = Modifier.width(30.dp))
                        Checkbox(checked = state.petfriendly , onCheckedChange = { viewModel.changePet()} )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = stringResource(R.string.accept__children))
                        Spacer(modifier = Modifier.width(30.dp))
                        Checkbox(checked = state.children , onCheckedChange = { viewModel.changeChildren() } )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.car_women),
                        contentDescription = "Image",
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.TopCenter
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(R.string.helps_driver) ,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            text = stringResource(R.string.have_safer) ,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            text = stringResource(R.string.comfortable_trip) ,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.health_information) ,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                HealthItem(
                    text = stringResource(R.string.allergy),
                    checked = state.allergy,
                    onCheck = { viewModel.changeAllergy() },
                    onTextChange = { viewModel.allergyText(it) },
                    textValue = state.allergyText
                )
                Spacer(modifier = Modifier.height(20.dp))
                HealthItem(
                    text = stringResource(R.string.chairwheel),
                    checked = state.chainWheel,
                    onCheck = { viewModel.changeChair() },
                    onTextChange = { viewModel.chairText(it) },
                    textValue = state.chainWheelText
                )
                Spacer(modifier = Modifier.height(20.dp))
                HealthItem(
                    text = stringResource(R.string.medication),
                    checked = state.medication,
                    onCheck = { viewModel.changeMedication() },
                    onTextChange = { viewModel.medicationText(it) },
                    textValue = state.medicationText
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                AnotherInfo(text = state.otherInfo, { viewModel.otherText(it)})
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 2.dp,
                            focusedElevation = 10.dp
                        )
                    ) {
                        Text(text = stringResource(id = R.string.accept))
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreferenceScreenPreview() {
    PreferenceScreen( {} )
}