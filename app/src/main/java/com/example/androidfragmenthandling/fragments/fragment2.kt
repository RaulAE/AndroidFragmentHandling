package com.example.androidfragmenthandling.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidfragmenthandling.R


class fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_fragment2, container, false)
        var displayMessage = arguments?.getString("txtAtoB")
        val textRecv = view.findViewById<TextView>(R.id.txtRecv)
        textRecv.setText(displayMessage)
        return view
    }


}