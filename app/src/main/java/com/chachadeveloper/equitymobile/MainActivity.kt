package com.chachadeveloper.equitymobile

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.activity.RootNavGraph
import com.chachadeveloper.equitymobile.presentation.bottomNav.StandardScaffold
import com.dev.chacha.resources.EquityMobileTheme
import com.dev.chacha.util.Graph
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private val isDone: MutableState<Boolean> = mutableStateOf(false)
    private val permissionRequestCode = 123 // You can choose any request code
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val localContext = LocalContext.current
            LaunchedEffect(Unit) {
                checkAndRequestPermission()
            }
            val isSystemDarkState = isSystemInDarkTheme()
            val systemUiController = rememberSystemUiController()
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            EquityMobileTheme() {
                StandardScaffold(
                    navController = navController,
                    showBottomBar = navBackStackEntry?.destination?.route in listOf(
                        Graph.ACCOUNTS_SCREEN_ROUTE,
                        Graph.HOME_SCREEN_ROUTE,
                        Graph.MORE_SCREEN_ROUTE,
                    ),
                    modifier = Modifier.fillMaxSize(),
                    onFabClick = {
                        navController.navigate(Graph.HOME_SCREEN_ROUTE)
                    }
                ) {
                    RootNavGraph(navController)
                }


            }
        }

    }

    private fun checkAndRequestPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                permissionRequestCode
            )
        } else {
            isDone.value = true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == permissionRequestCode && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            isDone.value = true
        }
    }

}

@Composable
fun Greetings() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Hello World!")
    }
}
