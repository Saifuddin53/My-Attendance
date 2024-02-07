package com.littlelemon.myattendance

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun TimeTableActivity() {

    val calendar = Calendar.getInstance()

    val date = remember { mutableStateOf(getCurrentDate(calendar)) }
    val day = remember { mutableStateOf(getCurrentDay(calendar)) }

    TopAppBar(date, day, calendar)

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        SubjectItem("COA")
        SubjectItem("Physics")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(date: MutableState<String>,
                      day: MutableState<String>,
                      calendar: Calendar,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "${day.value} , ${date.value}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { getPreviousDateAndDay(date, day, calendar) }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Localized description",
                            Modifier.size(48.dp)
                        )
                    }
                } ,actions = {
                    IconButton(onClick = { getNextDateAndDay(date, day, calendar) }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "Localized description",
                            Modifier.size(48.dp)
                        )
                    }
                }
            )
        }
    ) {}
}


@Composable
fun SubjectItem(subjectName: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .height(100.dp)
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable { }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = subjectName,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(70.dp))

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .size(27.dp)) {
                Icon(imageVector = Icons.Default.Close,
                    contentDescription = "Absent",
                    )
            }

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Update",
                    )
            }

        }
    }
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentDate(calendar: Calendar): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy") // You can customize the date format here
    return dateFormat.format(calendar.time)
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentDay(calendar: Calendar): String {
    val dayFormat = SimpleDateFormat("EEEE") // Day of the week
    return dayFormat.format(calendar.time)
}

@SuppressLint("SimpleDateFormat")
private fun getPreviousDateAndDay(date: MutableState<String>, day: MutableState<String>, calendar: Calendar) {
    calendar.add(Calendar.DAY_OF_YEAR, -1) // Subtract 1 day

    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    date.value = dateFormat.format(calendar.time)


    val dayFormat = SimpleDateFormat("EEEE")
    day.value = dayFormat.format(calendar.time)
}

@SuppressLint("SimpleDateFormat")
private fun getNextDateAndDay(date: MutableState<String>, day: MutableState<String>, calendar: Calendar){
    calendar.add(Calendar.DAY_OF_YEAR, 1) // Add 1 day

    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    date.value = dateFormat.format(calendar.time)

    val dayFormat = SimpleDateFormat("EEEE")
    day.value = dayFormat.format(calendar.time)

}
