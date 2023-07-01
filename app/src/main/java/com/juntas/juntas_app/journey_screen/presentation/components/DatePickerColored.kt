package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.juntas.juntas_app.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DatePickerColored(
    onClose: (Long) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val currentDate = remember {
        mutableStateOf(Calendar.getInstance())
    }
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = { onDismiss() },
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 2.dp,
                            focusedElevation = 10.dp
                        )
                    ) {
                        Text(text = stringResource(R.string.cancel))
                    }
                    //Ready
                    Button(
                        onClick = {
                            if (datePickerState.selectedDateMillis != null) {
                                if(datePickerState.selectedDateMillis!! >= currentDate.value.timeInMillis) {
                                    currentDate.value.timeInMillis = datePickerState.selectedDateMillis!!
                                    onClose(datePickerState.selectedDateMillis!!)
                                } else {
                                    Toast.makeText(context, "Invalid date", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(context, "The date was not selected", Toast.LENGTH_SHORT).show()
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 2.dp,
                            focusedElevation = 10.dp
                        )
                    ) {
                        Text(text = stringResource(R.string.accept))
                    }
                }

            },
            modifier = modifier,
            properties = DialogProperties(),
            colors = DatePickerDefaults.colors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.primary,
                headlineContentColor = MaterialTheme.colorScheme.onBackground,
                weekdayContentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            DatePicker(state = datePickerState)
        }
    }

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview
fun DatePickerColoredPreview() {
 DatePickerColored( {}, {})
}