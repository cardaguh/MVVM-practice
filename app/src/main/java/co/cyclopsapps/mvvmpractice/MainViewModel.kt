package co.cyclopsapps.mvvmpractice

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
class MainViewModel: ViewModel(), CoroutineScope {

    private val states: MutableLiveData<ScreenState<RestaurantState>> = MutableLiveData()
    private val repository = RestaurantRepository()

    var restaurantResponse: RestaurantResponse? = null

    private val viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = viewModelJob + Dispatchers.Default

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getState(): MutableLiveData<ScreenState<RestaurantState>> {
        return states
    }


    fun getRestaurantData() {
        states.value = ScreenState.Loading
        viewModelScope.launch {
            repository.getRestaurant()?.body()?.let {
                restaurantResponse = it
                states.value = ScreenState.Render(RestaurantState.ShowRestaurantData(it))
            } ?: run {
                states.value = ScreenState.ErrorServer
            }
        }
    }

}

