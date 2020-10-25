package co.cyclopsapps.mvvmpractice

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */

data class RestaurantResponse (
        val company: Restaurant
)

data class Restaurant (
    val restaurantId: String = "",
    val imagen: String = "",
    val nombre: String = "",
    val description: String = ""
)