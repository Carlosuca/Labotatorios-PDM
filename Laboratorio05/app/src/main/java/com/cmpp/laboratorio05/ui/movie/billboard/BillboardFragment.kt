package com.cmpp.laboratorio05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmpp.laboratorio05.R
import com.cmpp.laboratorio05.data.model.MovieModel
import com.cmpp.laboratorio05.databinding.FragmentBillboardBinding
import com.cmpp.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.cmpp.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

private lateinit var movieCardView: CardView

private lateinit var buttonAddMovie: FloatingActionButton
private lateinit var binding: FragmentBillboardBinding
private lateinit var adapter: MovieRecyclerViewAdapter


class BillboardFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)

        setRecycleView(view)

        binding.actionToCreatMovie.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        }




       /*buttonAddMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        } */

        //movieCardView.setOnClickListener{
        //    it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        //}
    }

    fun bind(view: View){
        buttonAddMovie = view.findViewById(R.id.action_toCreat_movie)
        //movieCardView = view.findViewById(R.id.card_movie)
    }

    private fun showSelectedItem(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)

        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)



    }

    fun onItemSelected(movie: MovieModel){

    }



    private fun displayMovies() {
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecycleView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)

        }
        binding.recyclerView.adapter = adapter
        displayMovies()
    }

}