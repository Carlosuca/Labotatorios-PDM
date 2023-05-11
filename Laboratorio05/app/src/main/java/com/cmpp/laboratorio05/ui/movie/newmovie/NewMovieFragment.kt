package com.cmpp.laboratorio05.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cmpp.laboratorio05.data.model.MovieModel
import com.cmpp.laboratorio05.databinding.FragmentCreateMovieBinding
import com.cmpp.laboratorio05.ui.movie.viewmodel.MovieViewModel


class NewMovieFragment : Fragment() {

    private lateinit var binding: FragmentCreateMovieBinding
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()

        binding.createMovieButton.setOnClickListener {
            createMovie()
            //Toast.makeText(context, "Nueva pelicula agregada correctamente", LENGTH_SHORT).show()
        }
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus()  {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CRATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getMovies().toString())

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                    Toast.makeText(context, "Nueva pelicula agregada correctamente", LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun createMovie() {
        val newMovie = MovieModel(
            binding.createMovieNameEditText.text.toString(),
            binding.createMovieCategoryEditText.text.toString(),
            binding.createMovieCalificationEditText.text.toString(),
            binding.createMovieDescriptionEditText.text.toString()
        )

        viewModel.addMovie(newMovie)
        Log.d("LIST_MOVIES", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }

}