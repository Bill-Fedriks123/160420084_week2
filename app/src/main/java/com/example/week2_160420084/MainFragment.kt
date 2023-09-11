package com.example.week2_160420084

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var number1 = (0..100).random()
        var number2 = (0..100).random()

        txtNumber.text = number1.toString() + " + " + number2.toString()
        var result = number1 + number2

        btnSubmit.setOnClickListener {
            val playersResult = txtAnswer.text.toString().toInt()

            var playerScore = 0
            if (playersResult == result){
                playerScore = 100
            }
            val action = MainFragmentDirections.actionGameFragment(playerScore.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}