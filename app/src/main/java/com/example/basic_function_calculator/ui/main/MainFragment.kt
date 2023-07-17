package com.example.basic_function_calculator.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.basic_function_calculator.R
import kotlin.math.min

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        var message = view.findViewById<TextView>(R.id.message)

        viewModel.result.observe(viewLifecycleOwner, Observer {
            message.text = it.toString()
        })
        var no1 = view.findViewById<EditText>(R.id.editTextNumber)
        var no2 = view.findViewById<EditText>(R.id.editTextNumber)

        var add = view.findViewById<Button>(R.id.additionButton)
        add.setOnClickListener {
            viewModel.addition(no1.text.toString().toDouble(), no2.text.toString().toDouble())
        }

        var min = view.findViewById<Button>(R.id.subtractButton)
        min.setOnClickListener {
            viewModel.subtraction(no1.text.toString().toDouble(), no2.text.toString().toDouble())
        }

        var multi = view.findViewById<Button>(R.id.multiplicationButton)
        multi.setOnClickListener {
            viewModel.multiplication(
                no1.text.toString().toDouble(),
                no2.text.toString().toDouble()
            )
        }

        var division = view.findViewById<Button>(R.id.divisionButton)
        division.setOnClickListener {
            viewModel.division(no1.text.toString().toDouble(), no2.text.toString().toDouble())
        }

        return view
    }
}