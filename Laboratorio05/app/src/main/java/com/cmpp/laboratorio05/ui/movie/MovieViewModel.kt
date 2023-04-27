package com.cmpp.laboratorio05.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cmpp.laboratorio05.MovieReviewerApplication
import com.cmpp.laboratorio05.data.model.MovieModel
import com.cmpp.laboratorio05.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovie(movie: MovieModel) = repository.addMovies(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }

}