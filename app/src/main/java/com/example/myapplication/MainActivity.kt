package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import org.w3c.dom.Text
import android.widget.Toast
import kotlin.math.sqrt



class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView


    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }


    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            var result = resultTextView.text.toString()

            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }




    fun operationClick(clickedView: View) {

        if (clickedView is TextView) {

            val result = resultTextView.text.toString()

            if (result.isNotEmpty()) {
                operand = result.toDouble()
            }

            operation = clickedView.text.toString()

            resultTextView.text = ""


        }

    }



    fun equalsClick(clickedView: View) {

        val secOperandText = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()){
            secOperand = secOperandText.toDouble()

        }
        when(operation) {

            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "%" -> resultTextView.text = ((operand * secOperand) / 100).toString()
            "/" -> {

                if ( secOperandText == "0") {

                    Toast.makeText(applicationContext, "Can't divide by zero.", Toast.LENGTH_SHORT).show()
                }
                else {
                    resultTextView.text = (operand / secOperand).toString() }
            }

        }


    }


    fun floatClick(clickedView: View){

        val result = resultTextView.text.toString()

        if ("." !in result && result.isNotEmpty()){
            resultTextView.text = "$result."
        }

    }


    fun delClick(clickedView: View){

        resultTextView.text = resultTextView.text.toString().dropLast(1)

    }


    fun clearClick(clickedView: View){

        resultTextView.text = ""

    }


   fun sqrtClick(clickedView: View){

        val result = resultTextView.text.toString()

        if (result.isNotEmpty()) {

            val sqrt = sqrt(result.toDouble())
            resultTextView.text = sqrt.toString()

        } else {
            Toast.makeText(applicationContext, "Enter number.", Toast.LENGTH_SHORT).show()
        }

    }

}











