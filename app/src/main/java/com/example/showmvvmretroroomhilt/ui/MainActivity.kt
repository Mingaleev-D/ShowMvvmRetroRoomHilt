package com.example.showmvvmretroroomhilt.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.showmvvmretroroomhilt.ui.components.BtnNav
import com.example.showmvvmretroroomhilt.ui.navigation.Destination
import com.example.showmvvmretroroomhilt.ui.screen.CollectionScreen
import com.example.showmvvmretroroomhilt.ui.screen.MainScreen
import com.example.showmvvmretroroomhilt.ui.theme.ShowMvvmRetroRoomHiltTheme

class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         ShowMvvmRetroRoomHiltTheme {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

               val navController = rememberNavController()

               MainScaffold(navController = navController)
            }
         }
      }
   }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScaffold(navController: NavHostController) {

   val scaffoldState = rememberScaffoldState()

   Scaffold(
       scaffoldState = scaffoldState,
       bottomBar = {
          BtnNav(
              navHostController = navController
          )
       }
   ) {

      NavHost(navController = navController, startDestination = Destination.MainScreen.route) {

         composable(Destination.MainScreen.route) {
            MainScreen()
         }

         composable(Destination.CollectionScreen.route) {
            CollectionScreen()
         }

         composable(Destination.DetailScreen.route) { navBackStackEntry ->

         }
      }
   }
}

