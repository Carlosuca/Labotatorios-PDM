package com.cmpp.laboratorio05

import android.app.Application
import com.cmpp.laboratorio05.data.movies
import com.cmpp.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication: Application() {

    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}