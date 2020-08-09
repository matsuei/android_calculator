package com.example.android_calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.time.toDuration


class MainActivity : AppCompatActivity() {
    enum class Symbol(val text: String) {
        Plus("+"),
        Minus("−"),
        Times("×"),
        Divide("÷"),
    }

    private var numberArrayList = arrayListOf<Double>()
    private var symbolArrayList = arrayListOf<Symbol>()
    private var recentInputtedNumber: String = ""
    private var isShowingResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun addNumber(inputtedNumber: Int) {
        val textView = findViewById<TextView>(R.id.resultText)
        if (isShowingResult) {
            textView.text = ""
            isShowingResult = false
        }
        textView.text = buildString {
            append(textView.text.toString())
            append(inputtedNumber.toString())
        }
        this.recentInputtedNumber = buildString {
            append(recentInputtedNumber)
            append(inputtedNumber.toString())
        }
    }

    private fun clearAll() {
        val resultTextView = findViewById<TextView>(R.id.resultText)
        resultTextView.text = ""
        numberArrayList.clear()
        symbolArrayList.clear()
    }

    private fun selectSymbol(symbol: Symbol) {
        if (numberArrayList.count() > 0 && numberArrayList.count() != symbolArrayList.count()) {
            return
        }
        numberArrayList.add(recentInputtedNumber.toDouble())
        symbolArrayList.add(symbol)
        val textView = findViewById<TextView>(R.id.resultText)
        textView.text = buildString {
            append(textView.text.toString())
            append(symbol.text)
        }
        recentInputtedNumber = ""
    }

    private fun selectEqual() {
        if (numberArrayList.count() != symbolArrayList.count()) {
            return
        }
        numberArrayList.add(recentInputtedNumber.toDouble())
        recentInputtedNumber = ""
        calculate()
        val resultText = numberArrayList.first().toString()
        clearAll()
        val textView = findViewById<TextView>(R.id.resultText)
        textView.text = resultText
        isShowingResult = true
    }

    private fun calculate() {
        if (symbolArrayList.isEmpty()) {
            return
        }
        val index = symbolArrayList.indexOfFirst {
            it == Symbol.Times || it == Symbol.Divide
        }
        if (index != -1) {
            var result = 0.0
            var symbol = symbolArrayList[index]
            if (symbol == Symbol.Divide) {
                result = numberArrayList[index].div(numberArrayList[index + 1])
            } else if (symbol == Symbol.Times) {
                result = numberArrayList[index].times(numberArrayList[index + 1])
            }
            refreshArray(index,result)
            calculate()
            return
        }
        var result = 0.0
        var symbol = symbolArrayList[0]
        if (symbol == Symbol.Minus) {
            result = numberArrayList[0].minus(numberArrayList[1])
        } else if (symbol == Symbol.Plus) {
            result = numberArrayList[0].plus(numberArrayList[1])
        }
        refreshArray(0,result)
        calculate()
    }

    private fun refreshArray(index: Int, result: Double) {
        numberArrayList.removeAt(index)
        numberArrayList.removeAt(index)
        numberArrayList.add(index,result)
        symbolArrayList.removeAt(index)
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
        selectEqual()
    }

    fun onDotButtonClick(view: View) {

    }

    fun onClearButtonClick(view: View) {
        clearAll()
    }
}