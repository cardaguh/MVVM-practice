package co.cyclopsapps.mvvmpractice.domain

import co.cyclopsapps.mvvmpractice.data.Restaurant
import co.cyclopsapps.mvvmpractice.data.RestaurantList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
interface WebService {

    /*@GET()
    suspend fun getRestaurantByName(@Query(value = "restaurant?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYiI6InJlc3RhdXJhbnRhcHAiLCJjaWQiOiIxIn0._ri2Dghqcg-O1Yja5GCTENti3XobgcvB7-psyZLpCtA") restaurantName: String): RestaurantList*/

    @GET("restaurant?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYiI6InJlc3RhdXJhbnRhcHAiLCJjaWQiOiIxIn0._ri2Dghqcg-O1Yja5GCTENti3XobgcvB7-psyZLpCtA")
    suspend fun fetchRestaurants() : List<Restaurant>
}