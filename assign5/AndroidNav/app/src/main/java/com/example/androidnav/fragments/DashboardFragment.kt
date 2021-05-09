package com.example.androidnav.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidnav.R

/*
 *  Created by Nikoloz Katsitadze on 5/6/21
 */

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textView).text =
            DashboardFragmentArgs.fromBundle(requireArguments()).amount.toString()
    }
    
}