package com.example.androidnav.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidnav.R

class JobsFragment : Fragment(R.layout.fragment_jobs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.jobsText).text =
            JobsFragmentArgs.fromBundle(requireArguments()).job
    }
}
