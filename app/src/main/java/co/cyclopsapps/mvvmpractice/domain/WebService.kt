package co.cyclopsapps.mvvmpractice.domain

import co.cyclopsapps.mvvmpractice.data.RestaurantList
import retrofit2.http.Query

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
interface WebService {

    suspend fun getRestaurantByName(@Query(value = "s") restaurantName: String): RestaurantList
}