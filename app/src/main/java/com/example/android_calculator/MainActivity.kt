package com.example.android_calculator

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun addNumber(inputtedNumber: Int) {
        val textView = findViewById<TextView>(R.id.resultText)
        textView.text = buildString {
            append(textView.text.toString())
            append(inputtedNumber.toString())
        }
    }

    private fun clearResultText() {
        val resultTextView = findViewById<TextView>(R.id.resultText)
        resultTextView.text = ""
        val symbolTextView = findViewById<TextView>(R.id.symbolText)
        symbolTextView.text = ""
    }

    enum class Symbol(val text: String) {
        Plus("+"),
        Minus("−"),
        Times("×"),
        Divide("÷"),
    }

    private fun selectSymbol(symbol: Symbol) {
        val textView = findViewById<TextView>(R.id.symbolText)
        textView.text = symbol.text
    }

    fun onZeroButtonClick(view: View) {
        addNumber(0)
    }

    fun onOneButtonClick(view: View) {
        addNumber(1)
    }

    fun onTwoButtonClick(view: View) {
        addNumber(2)
    }

    fun onThreeButtonClick(view: View) {
        addNumber(3)
    }

    fun onFourButtonClick(view: View) {
        addNumber(4)
    }

    fun onFiveButtonClick(view: View) {
        addNumber(5)
    }

    fun onSixButtonClick(view: View) {
        addNumber(6)
    }

    fun onSevenButtonClick(view: View) {
        addNumber(7)
    }

    fun onEightButtonClick(view: View) {
        addNumber(8)
    }

    fun onNineButtonClick(view: View) {
        addNumber(9)
    }

    fun onPlusButtonClick(view: View) {
        selectSymbol(Symbol.Plus)
    }

    fun onMinusButtonClick(view: View) {
        selectSymbol(Symbol.Minus)
    }

    fun onTimesButtonClick(view: View) {
        selectSymbol(Symbol.Times)
    }

    fun onDivideButtonClick(view: View) {
        selectSymbol(Symbol.Divide)
    }

    fun onEqualButtonClick(view: View) {

    }

    fun onDotButtonClick(view: View) {

    }

    fun onClearButtonClick(view: View) {
        clearResultText()
    }
}