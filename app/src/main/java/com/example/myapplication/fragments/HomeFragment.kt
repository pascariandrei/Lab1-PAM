package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_horner.*
import java.time.DateTimeException
import java.time.format.DateTimeFormatter
import java.util.*

class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horner, container, false)
    }

    fun getIntValue(stringValue: String): Int {
        if (stringValue.length > 0) {
            return Integer.parseInt(stringValue)
        }
        return 0;
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button123.setOnClickListener {

            var dayinp = getIntValue(day.text.toString().trim())
            var monthinp = getIntValue(month.text.toString())
            var yearinp = getIntValue(year.text.toString())

            val dayCalc: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            val monthCalc: Int = Calendar.getInstance().get(Calendar.MONTH)//9

            val yearCalc: Int = Calendar.getInstance().get(Calendar.YEAR)



            var myday = dayCalc - dayinp
            var mymmonth = monthCalc -1  - monthinp
            var myyear = yearCalc - yearinp
            mx.text = "$myyear ani $mymmonth luni  $myday zile "

        }
    }
}

