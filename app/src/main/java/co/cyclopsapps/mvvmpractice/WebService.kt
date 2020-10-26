package co.cyclopsapps.mvvmpractice

//import co.cyclopsapps.mvvmpractice.data.RestaurantList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
interface WebService {

    @GET("restaurant")
    suspend fun getRestaurantByName(@Query(value = "token") tokenValue: String)
            : Response<RestaurantResponse>
}