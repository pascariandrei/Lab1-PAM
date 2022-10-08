package com.example.myapplication.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_float.*


class FloatCalculationFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_float, container, false)
    }

    private fun getIntValue(stringValue: String): Int {
        if (stringValue.length > 0) {
            return Integer.parseInt(stringValue)
        }
        return 0
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        BinBtn.setOnClickListener {


            val inpNumforCC =
                getIntValue(binInput.text.toString().map { '1' - it }.joinToString(""))
            val inpNumforDec = getIntValue(binInput.text.toString())

            val YinpNumforCC = getIntValue(yInput.text.toString().map { '1' - it }.joinToString(""))
            val YinpNumforDec = getIntValue(yInput.text.toString())

            // if (inpNumforDec > 0) {

            val DecResult = convertBinaryToDecimal(inpNumforDec)//converteaza in zecimal
            val CCconverted = convertBinaryToDecimal(inpNumforCC.inv())//converteaza in zecimall

            val CCconverted1 = convertBinaryToDecimal(inpNumforCC)//converteaza in zecimall1

            val YDecResult = convertBinaryToDecimal(YinpNumforDec)//converteaza in zecimal
            val YCCconverted = convertBinaryToDecimal(YinpNumforCC.inv())//converteaza in zecimal

            val mxfinal = Integer.toBinaryString(CCconverted)


            val myfinal = Integer.toBinaryString(YCCconverted)

            val CCwith0 = Integer.toBinaryString(CCconverted + 1)
            val YCCwith0 = Integer.toBinaryString(YCCconverted + 1)

            val CCwith1 = Integer.toBinaryString(-DecResult)
            val YCCwith1 = Integer.toBinaryString(-YDecResult)

            val numSizeCC = inpNumforCC.toString().length
            val numSizeCD = inpNumforDec.toString().length
            val YnumSizeCC = YinpNumforCC.toString().length
            val YnumSizeCD = YinpNumforDec.toString().length


            val frstEl = binInput.text.toString().first()
            val YfrstEl = yInput.text.toString().first()

            val mxfinal1 = Integer.toBinaryString(CCconverted.inv()).takeLast(numSizeCC)



            //mX.text = mxfinal.toString().takeLast(numSizeCC)
            /*mX.text = inpNumforDec.toString().takeLast(numSizeCD)
            mY.text = CCwith1.toString().get(0).toString() + '.' + inpNumforDec.toString().takeLast(numSizeCC-1)*/



            fun getOutputX(firstEl: Char): String {
                if (firstEl == '0') {
                    return mxfinal.takeLast(numSizeCC - 1  )
                } else if (firstEl == '1') {
                    return inpNumforDec.toString().takeLast(numSizeCD - 1)
                }
                return ""
            }

            fun getOutputY(firstEl: Char): String {
                if (firstEl == '0') {
                    return myfinal.takeLast(YnumSizeCC - 1)
                } else if (firstEl == '1') {
                    return YinpNumforDec.toString().takeLast(YnumSizeCD - 1)
                }
                return ""
            }

            fun getFirstElementX(firstEL: String): String {
                if (firstEL == "1") {
                    return binInput.text.toString().first() + "." + getOutputX(frstEl)
                } else if (firstEL == "0") {
                    return "1" + '.' + getOutputX(frstEl)
                }
                return "0"
            }
fun getFirstElementY(firstEL: String): String {
                if (firstEL == "1") {
                    return yInput.text.toString().first() + "." + getOutputY(YfrstEl)
                } else if (firstEL == "0") {
                    return "1" + '.' + getOutputY(YfrstEl)
                }
                return "0"
            }






            //mX.text = mxfinal.get(0).toString() + '.' + getOutputX(frstEl)
            mX.text = getFirstElementX(CCwith0.get(0).toString())
            mY.text = getFirstElementY(YCCwith0.get(0).toString())
            //mY.text = myfinal.get(0).toString() + '.' + getOutputY(YfrstEl)


            // } else Log.d("Eror", "Error")


        }
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