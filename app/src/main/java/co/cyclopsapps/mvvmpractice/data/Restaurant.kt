package co.cyclopsapps.mvvmpractice.data

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
data class Restaurant (
    val restaurantId: String = "",
    val imagen: String = "",
    val nombre: String = "",
    val description: String = ""
)

data class RestaurantList (
    val restaurantList: List<Restaurant>
)