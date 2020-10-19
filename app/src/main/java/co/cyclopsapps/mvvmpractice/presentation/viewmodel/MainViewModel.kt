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
class MainViewModel: ViewModel(), CoroutineScope {

    private val states: MutableLiveData<ScreenState<RestaurantState>> = MutableLiveData()
    private val repository = RestaurantRepository()

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
            repository.getRestaurantData()?.body()?.let {
                states.value = ScreenState.Render(RestaurantState.ShowRestaurantData(it.company))
            } ?: run {
                states.value = ScreenState.ErrorServer
            }
        }
    }



}