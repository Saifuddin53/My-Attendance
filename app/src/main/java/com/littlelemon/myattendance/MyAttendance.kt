package com.littlelemon.myattendance

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.myattendance.ui.screen.EditTimeTable
import com.littlelemon.myattendance.ui.screen.InitialActivity
import com.littlelemon.myattendance.ui.screen.Route
import com.littlelemon.myattendance.ui.screen.Status
import com.littlelemon.myattendance.ui.screen.SubjectsActivity
import com.littlelemon.myattendance.ui.screen.TimeTableActivity

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