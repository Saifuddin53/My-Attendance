package com.littlelemon.myattendance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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



