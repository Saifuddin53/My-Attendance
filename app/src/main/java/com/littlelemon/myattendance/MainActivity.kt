package com.littlelemon.myattendance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.myattendance.ui.theme.MyAttendanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAttendanceTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Initial.name
    ) {
        composable(route = Route.Initial.name) {
            InitialActivity(navController)
        }

        composable(route = Route.AddSubjects.name) {
            SubjectsActivity()
        }

        composable(route = Route.EditTimeTable.name) {
            EditTimeTable()
        }

        composable(route = Route.TimeTable.name) {
            TimeTableActivity()
        }

        composable(route = Route.Status.name) {
            Status()
        }



    }
}

