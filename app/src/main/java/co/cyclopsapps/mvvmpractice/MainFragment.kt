package co.cyclopsapps.mvvmpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var restaurantViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restaurantViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //restaurantViewModel.getState().observe(this, Observer { onChanged(it) })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        button.setOnClickListener { view ->
            view.findNavController().navigate(R.id.detailFragment)
        }
    }


    /**
     * Validate answers
     * @param screenState screenState type to validate
     */
   /* private fun onChanged(screenState: ScreenState<ScreenState>?) {
        this@MainFragment.context?.let {
            screenState?.let {
                if (screenState is ScreenState.Render) {
                    updateUI(screenState.renderState)
                } else {
                    when (screenState) {
                        ScreenState.Loading -> {
                            //show progress
                        }
                        ScreenState.InternetError -> {
                            //hide progress
                           
                        }

                        ScreenState.ErrorServer -> {
                        }
                        else -> {
                            //hide progress
                        }
                    }
                }
            }
        }
    }*/

    /**
     * Validate different kind of response
     * @param renderState type de renderState to validate
     */
    private fun updateUI(renderState: Any) {
        this@MainFragment.context?.let {
            when (renderState) {
                is RestaurantState.ShowRestaurantData -> {
                  //val company = renderState.company
                }

                else -> {
                    //hide progress
                }
            }
        }
    }


    private fun setupRecyclerView() {
        rv_restaurants.layoutManager = LinearLayoutManager(requireContext())
        rv_restaurants.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }
}