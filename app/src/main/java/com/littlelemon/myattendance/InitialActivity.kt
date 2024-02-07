package com.littlelemon.myattendance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.sourceInformation
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun InitialActivity(
    navController: NavController,
    onButtonClicked: (String) -> Unit = {Route -> navController.navigate(Route)}
) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Button(
            onClick = { onButtonClicked("AddSubjects") },
            modifier = Modifier.padding(36.dp)
            ) {
            Text(text = "Add Subjects",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { onButtonClicked("EditTimeTable") },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Edit Timetable ",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { onButtonClicked("TimeTable") },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Timetable",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { onButtonClicked("Status") },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Status",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
    }
}


@Preview
@Composable
fun InitialActivityPreview() {
    InitialActivity(
        navController = rememberNavController(),
        onButtonClicked = {name -> println(name) }
    )
}


