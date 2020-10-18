package co.cyclopsapps.mvvmpractice.domain

import co.cyclopsapps.mvvmpractice.data.Restaurant
import co.cyclopsapps.mvvmpractice.utils.Resource

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
class DataSource(private val apiService: WebService) {
    //suspend fun getRestaurantByName(restaurantName: String): Resource<List<Restaurant>>

    suspend fun getRestaurants(): List<Restaurant> {
        val restaurantList = apiService.fetchRestaurants()
        return restaurantList
    }

}