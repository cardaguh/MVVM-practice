package co.cyclopsapps.mvvmpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.mvvmpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    // BINDING
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var restaurantViewModel: MainViewModel

    private  lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restaurantViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        restaurantViewModel.getState().observe(this, Observer { onChanged(it) })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        with(binding){
            button.setOnClickListener { view ->
                restaurantViewModel.getRestaurantData()
               // view.findNavController().navigate(R.id.detailFragment)
            }
        }


    }


    /**
     * Validate answers
     * @param screenState screenState type to validate
     */
    private fun onChanged(screenState: ScreenState<RestaurantState>?) {
        this@MainFragment.context?.let {
            screenState?.let {
                if (screenState is ScreenState.Render) {
                    updateUI(screenState.renderState)
                } else {
                    when (screenState) {
                        ScreenState.Loading -> {
                            binding.progress.isVisible = true
                        }
                        ScreenState.InternetError -> {
                            binding.progress.isVisible = false
                           
                        }

                        ScreenState.ErrorServer -> {
                            binding.progress.isVisible = false
                            // show error
                        }
                        else -> {
                            binding.progress.isVisible = false

                        }
                    }
                }
            }
        }
    }

    /**
     * Validate different kind of response
     * @param renderState type de renderState to validate
     */
    private fun updateUI(renderState: Any) {
        this@MainFragment.context?.let {
            when (renderState) {
                is RestaurantState.ShowRestaurantData -> {

                    val restaurantFakeList: MutableList<Restaurant> = mutableListOf<Restaurant>()
                    restaurantFakeList.add(renderState.restauratData)
                    adapter.setRestaurantList(restaurantFakeList)
                    binding.progress.isVisible = false

                }

                else -> {
                    binding.progress.isVisible = false
                }
            }
        }
    }


    private fun setupRecyclerView() {
         adapter = RestaurantAdapter()
        with(binding){
            rvRestaurants.layoutManager = LinearLayoutManager(requireContext())
            rvRestaurants.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            rvRestaurants.adapter = adapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}