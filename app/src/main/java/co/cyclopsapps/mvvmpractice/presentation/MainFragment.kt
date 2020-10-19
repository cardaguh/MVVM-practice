package co.cyclopsapps.mvvmpractice.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.mvvmpractice.R
import co.cyclopsapps.mvvmpractice.data.DataSourceImpl
import co.cyclopsapps.mvvmpractice.domain.RepoImpl
import co.cyclopsapps.mvvmpractice.presentation.viewmodel.MainViewModel
import co.cyclopsapps.mvvmpractice.presentation.viewmodel.VMFactory
import co.cyclopsapps.mvvmpractice.utils.Resource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var restaurantViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restaurantViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        restaurantViewModel.getState().observe(this, Observer { onChanged(it) })
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
    }


    /**
     * Validate answers
     * @param screenState screenState type to validate
     */
    private fun onChanged(screenState: ScreenState<ScreenState>?) {
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
                            view?.let { mView ->
                                Snackbar.make(mView, getString(R.string.no_internet_found), Snackbar.LENGTH_LONG)
                                        .setAction(getString(R.string.ok_label), null).show()
                            }
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
    }

    /**
     * Validate different kind of response
     * @param renderState type de renderState to validate
     */
    private fun updateUI(renderState: Any) {
        this@MainFragment.context?.let {
            when (renderState) {
                is RestaurantState.ShowRestaurantData -> {
                  val company = renderState.company
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