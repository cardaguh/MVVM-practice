
import retrofit2.Response
import timber.log.Timber


class RestaurantRepository {

    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.webseri .create(WebService::class.java)
    }

    /**
     *
     */
    suspend fun getRestaurant(): Response<RestaurantResponse>? {
        return try {
            apiService?.getRestaurantByName("token aqui")
        } catch (exception: Exception) {
            Timber.tag("getData").e(exception)
            null
        }
    }


}