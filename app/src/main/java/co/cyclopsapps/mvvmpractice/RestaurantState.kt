package co.cyclopsapps.mvvmpractice

/**
 * States for Restaurant
 */
sealed class RestaurantState {
    class ShowRestaurantData(
            var restauratData: Restaurant
    ) : RestaurantState()
}