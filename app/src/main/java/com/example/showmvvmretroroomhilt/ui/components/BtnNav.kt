package com.example.showmvvmretroroomhilt.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.showmvvmretroroomhilt.R
import com.example.showmvvmretroroomhilt.ui.navigation.Destination

/**
 * @author : Mingaleev D
 * @data : 16.10.2023
 */

@Composable
fun BtnNav(
    navHostController: NavHostController
) {

   BottomNavigation(
       elevation = 5.dp
   ) {

      val navBackStackEntry = navHostController.currentBackStackEntryAsState()
      val currentDestination = navBackStackEntry.value?.destination

      val iconMain = painterResource(id = R.drawable.ic_main_icon)
      val iconCollection = painterResource(id = R.drawable.ic_collections)

      BottomNavigationItem(
          selected = currentDestination?.route == Destination.MainScreen.route,
          onClick = {
             navHostController.navigate(Destination.MainScreen.route) {
                popUpTo(Destination.MainScreen.route)
                launchSingleTop = true
             }
          },
          icon = {
             Icon(painter = iconMain, contentDescription = null)
          },
          label = {
             Text(text = Destination.MainScreen.route)
          }
      )

      BottomNavigationItem(
          selected = currentDestination?.route == Destination.CollectionScreen.route,
          onClick = {
             navHostController.navigate(Destination.CollectionScreen.route){
                launchSingleTop = true
             }
          },
          icon = {
             Icon(painter = iconCollection, contentDescription = null)
          },
          label = {
             Text(text = Destination.CollectionScreen.route)
          })

   }

}