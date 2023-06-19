package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun ManyDialog(
    onDismiss: () -> Unit,
    onReady: () -> Unit,
    passenger: Int,
    children: Int,
    onMinusChildren: () -> Unit,
    onPlusChildren: () -> Unit,
    onPlusPassenger: () -> Unit,
    onMinusPassenger: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        textContentColor = MaterialTheme.colorScheme.onBackground,
        titleContentColor = MaterialTheme.colorScheme.onBackground,
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        onReady()

                              },
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 2.dp,
                        focusedElevation = 10.dp
                    )
                ) {
                    Text(text = stringResource(id = R.string.accept), style = MaterialTheme.typography.titleSmall)
                }
            }
        },
        title = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Close
                        , contentDescription = "Dismiss",
                        modifier = Modifier.clickable { onDismiss() }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.passenger), style = MaterialTheme.typography.headlineLarge)
                }
            }
        },
        text = {
            //Adultas
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier.width(130.dp)
                    ){
                        Text(text = stringResource(R.string.adult))
                    }

                    Box(
                        modifier = Modifier
                    ) {
                        Row(
                            modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            PassengersIncrement(
                                number = passenger ,
                                onMinus = { onMinusPassenger() } ,
                                onPlus = { onPlusPassenger() }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                //Menores
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier.width(130.dp)
                    ){
                        Text(text = stringResource(R.string.minors))
                    }

                    Box(
                        modifier = Modifier
                    ) {
                        Row(
                            modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            PassengersIncrement(
                                number = children ,
                                onMinus = { onMinusChildren() } ,
                                onPlus = { onPlusChildren() }
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
@Preview
fun ManyDialogPreview() {
    //ManyDialog({},{  })
}