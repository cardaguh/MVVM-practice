package co.cyclopsapps.mvvmpractice

import com.google.gson.annotations.SerializedName

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */

data class RestaurantResponse (
        val company: Restaurant,
        val category: MutableList<CategoryData>? = mutableListOf()
)

data class Restaurant (
    @SerializedName("id")
    val restaurantId: String = "",

    //Esto lo puse en el caso que tuvieses
    // un campo con nombre extraño
    @SerializedName("img")

    //Nombre al que se accede como atributo
    val imagen: String = "",


    val name: String = "",

    //Esto lo puse en el caso que tuvieses
    // un campo con nombre extraño
    @SerializedName("calle")

    //Nombre al que se accede como atributo
    val description: String = ""
)


data class CategoryData(
    val id: Int,
    val img: String = "",
    val name: String = ""
)