package co.cyclopsapps.mvvmpractice.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    private val viewModel by viewModels<MainViewModel> { VMFactory(
        RepoImpl(DataSourceImpl())
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.fetchRestaurantsList.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_restaurants.adapter = MainAdapter(requireContext(), result.data)
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrió una falla al conectar ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_restaurants.layoutManager = LinearLayoutManager(requireContext())
        rv_restaurants.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }
}