package com.example.showmvvmretroroomhilt.ui.navigation

sealed class Destination(val route: String) {
   object MainScreen : Destination("main_screen")
   object CollectionScreen : Destination("collection_screen")
   object DetailScreen : Destination("detail_screen/{characterId}"){
      fun createRoute(characterId: Int?)= "detail_screen/$characterId"

   }
}
