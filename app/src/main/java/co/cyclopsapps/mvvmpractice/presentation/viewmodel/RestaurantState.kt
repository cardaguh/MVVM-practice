/**
 * States for Restaurant
 */
sealed class RestaurantState {
    class ShowRestaurantData(
            var restauratData: ResturantData
    ) : RestaurantState()
}