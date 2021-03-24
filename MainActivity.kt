package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int,
                                       before: Int, count: Int) {
                displayTipAmount()
            }
        })

        slider.addOnChangeListener { slider, value, fromUser -> displayTipAmount() }
    }

    fun displayTipAmount() {
        if(edit_text.length() == 0 || edit_text.equals("")) {
            text_view.setVisibility(View.GONE)
        } else {
            text_view.setVisibility(View.VISIBLE)
            val billValue = edit_text.getText().toString().toDouble()
            val tipPercentage = slider.getValue().toInt()
            procent(billValue.toDouble(), tipPercentage.toDouble())
            //text_view.setText("Bill value: $billValue, tip percentage: $tipPercentage%")
        }
    }
    fun procent(a: Double, b: Double): Unit {
        val procent = a / 100 * b
        val g = "%.2f".format(procent)
        text_view.setText("${b.toInt()}% tip: $g")
    }
}
