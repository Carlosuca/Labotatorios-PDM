package com.cmpp.laboratorio05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cmpp.laboratorio05.R
import com.cmpp.laboratorio05.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false )
        return binding.root
    }

    /*companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }*/
}