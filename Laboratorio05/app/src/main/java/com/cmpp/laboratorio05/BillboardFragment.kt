package com.cmpp.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

private lateinit var buttonAddMovie: FloatingActionButton
private lateinit var movieCardView: CardView


class BillboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        buttonAddMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
        }

        movieCardView.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }
    }

    fun bind(view: View){
        buttonAddMovie = view.findViewById(R.id.action_toCreat_movie)
        movieCardView = view.findViewById(R.id.card_movie)
    }

}