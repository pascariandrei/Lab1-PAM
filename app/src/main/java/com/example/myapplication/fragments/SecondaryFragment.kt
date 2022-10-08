package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_secondary.*

class SecondaryFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary, container, false)
    }


    fun getIntValue(stringValue: String): Int {
        if (stringValue.length > 0) {
            return Integer.parseInt(stringValue)
        }
        return 0;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        SumBtn.setOnClickListener {
            //val decnum1 = decnum.getText()
            var inaltime = binInput1.text.toString()//primeste numarul 1
            var greutate = binInput2.text.toString()//primeste numarul 2

//            fun GetOutput(el1 : Double, el2:Double):Double{
//                return
//            }

            var imc = greutate.toDouble().div(inaltime.toDouble()).div(inaltime.toDouble()) * 10000
//
            sumOutput.text = imc.toString().take(5)
            if (imc < 18.49) {
                indexfinal.text = "Categorie Subponderala"
            } else if (imc >= 18.49 && imc <= 24.99) {
                indexfinal.text = "Greutate normala"
            } else if (imc >= 24.99 && imc <= 34.99) {
                indexfinal.text = "Obezitate gradul I"
            }


        }

    }

    fun sumBin(num1: String, num2: String): String {
        var num1 = num1
        var num2 = num2

        val bin1 = Integer.parseInt(num1, 2)
        val bin2 = Integer.parseInt(num2, 2)

        val result = bin1 + bin2

        val finaltest = Integer.toBinaryString(result)

        return finaltest
    }

    fun convertBinaryToDecimalFragment(num: Int): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Int

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }
}
