package co.cyclopsapps.mvvmpractice

import com.google.gson.annotations.SerializedName

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */

data class RestaurantResponse (
        val company: Restaurant
)

data class Restaurant (
    @SerializedName("id")
    val restaurantId: String = "",

    @SerializedName("img")
    val imagen: String = "",

    @SerializedName("name")
    val nombre: String = "",

    @SerializedName("calle")
    val description: String = ""
)