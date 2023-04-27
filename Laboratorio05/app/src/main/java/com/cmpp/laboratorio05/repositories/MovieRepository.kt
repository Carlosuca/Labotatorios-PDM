package com.cmpp.laboratorio05.repositories

import androidx.lifecycle.ViewModel
import com.cmpp.laboratorio05.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}