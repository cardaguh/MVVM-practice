package co.cyclopsapps.mvvmpractice
import retrofit2.Response
import timber.log.Timber


class RestaurantRepository {

    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }

    /**
     *
     */
    suspend fun getRestaurant(): Response<RestaurantResponse>? {
        return try {
                apiService?.getRestaurantByName("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYiI6InJlc3RhdXJhbnRhcHAiLCJjaWQiOiIxIn0._ri2Dghqcg-O1Yja5GCTENti3XobgcvB7-psyZLpCtA")
        } catch (exception: Exception) {
            Timber.tag("getData").e(exception)
            null
        }
    }



    suspend fun getRestaurant2() = apiService?.getRestaurantByName("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYiI6InJlc3RhdXJhbnRhcHAiLCJjaWQiOiIxIn0._ri2Dghqcg-O1Yja5GCTENti3XobgcvB7-psyZLpCtA")

}