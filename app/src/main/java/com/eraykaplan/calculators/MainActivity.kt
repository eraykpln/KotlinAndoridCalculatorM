package com.eraykaplan.calculators

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.eraykaplan.calculators.databinding.ActivityMainBinding


enum class Operations {
    ADDITION,
    SUBSTRACTION,
    MULTIPLY,
    DIVIDE
}


class MainActivity : AppCompatActivity() {


    lateinit var mainBinding: ActivityMainBinding
    var temp1: Double? = null
    var temp2: Double? = null
    var res: Double? = null
    var resString = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root

        super.onCreate(savedInstanceState)


        mainBinding.sumBut.setOnClickListener {
            mainBinding.resultText.text = calculation(Operations.ADDITION)

        }

        setContentView(view)
    }

    fun calculation(operation: Operations): String {
        //var LocalStorage = this.getSharedPreferences("com.eraykaplan.calculators", MODE_PRIVATE)
        temp1 = mainBinding.num1.text.toString().toDoubleOrNull()
        temp2 = mainBinding.num2.text.toString().toDoubleOrNull()
        if (temp1 != null && temp2 != null) {
            when (operation) // 0=summarize  1= substraction 2=multiplying 3= dividing
            {
                Operations.ADDITION -> res = temp1!! + temp2!!
                Operations.SUBSTRACTION -> res = temp1!! - temp2!!
                Operations.MULTIPLY -> res = temp1!! * temp2!!
                Operations.DIVIDE -> res = temp1!! / temp2!!

            }
            resString = "Result: $res"


        } else {
            resString = "please enter variable"
        }
        return resString
    }


    fun Sub(vieww: View) {
        mainBinding.resultText.text = calculation(Operations.SUBSTRACTION)


    }

    fun Multiply(vieww: View) {
        mainBinding.resultText.text = calculation(Operations.MULTIPLY)
    }

    fun Div(vieww: View) {
        mainBinding.resultText.text = calculation(Operations.DIVIDE)
    }
}