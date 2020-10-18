package co.cyclopsapps.mvvmpractice.presentation.viewmodel

import androidx.lifecycle.*
import co.cyclopsapps.mvvmpractice.data.Restaurant
import co.cyclopsapps.mvvmpractice.domain.Repo
import co.cyclopsapps.mvvmpractice.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
class MainViewModel(private val repo: Repo): ViewModel() {

    private val restaurantData = MutableLiveData<String>()

    fun setRestaurant(restaurantName: String) {
        restaurantData.value = restaurantName
    }

    init {
        setRestaurant("Restaurante")
    }

    val fetchRestaurantsList = restaurantData.distinctUntilChanged().switchMap {nombreRestaurante ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getRestaurantList(nombreRestaurante))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }
}