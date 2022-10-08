package com.example.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun getIntValue(stringValue: String): String {
        if (stringValue.length > 0) {
            return stringValue
        }
        return ""
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        BinBtn.setOnClickListener {


            val inp = getIntValue(binInput.text.toString())
            var countWord = inp.split("\\s".toRegex())
            var k1 = 0

            for (a in countWord) {

                    if (a.contains("a"))
                        k1++

            }



            res.text = k1.toString()

        }


        // } else Log.d("Eror", "Error")


    }

    fun convertBinaryToDecimal(num: Int): Int {
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