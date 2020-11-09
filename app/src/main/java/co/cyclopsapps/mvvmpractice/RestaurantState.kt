package co.cyclopsapps.mvvmpractice

/**
 * States for Restaurant
 */
sealed class RestaurantState {
    class ShowRestaurantData(
            var response: RestaurantResponse
    ) : RestaurantState()
}