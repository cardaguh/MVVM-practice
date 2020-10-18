package co.cyclopsapps.mvvmpractice.domain

import co.cyclopsapps.mvvmpractice.data.Restaurant
import co.cyclopsapps.mvvmpractice.utils.Resource

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
interface DataSource {
    suspend fun getRestaurantByName(restaurantName: String): Resource<List<Restaurant>>
}