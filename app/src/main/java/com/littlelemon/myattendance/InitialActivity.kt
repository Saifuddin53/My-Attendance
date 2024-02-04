package com.littlelemon.myattendance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun InitialActivity() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = { },
            modifier = Modifier.padding(36.dp)
            ) {
            Text(text = "Add Subjects",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Edit Timetable ",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Timetable",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(36.dp)
        ) {
            Text(text = "Status",
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp))
        }
    }
}