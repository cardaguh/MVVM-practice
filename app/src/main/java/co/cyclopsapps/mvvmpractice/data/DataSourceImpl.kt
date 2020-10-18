package co.cyclopsapps.mvvmpractice.data

import co.cyclopsapps.mvvmpractice.domain.DataSource
import co.cyclopsapps.mvvmpractice.utils.Resource

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
class DataSourceImpl: DataSource {
    override suspend fun getRestaurantByName(restaurantName: String): Resource<List<Restaurant>> {
        return Resource.Success(RetrofitClient.webService.getRestaurantByName(restaurantName).restaurantList)
    }
}