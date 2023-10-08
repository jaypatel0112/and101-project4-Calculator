package com.example.and101_project4_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.text.TextWatcher
import android.text.Editable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val base = findViewById<EditText>(R.id.value)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)


        fun updateResult(progress: Int, multiplier: String) {
            if (multiplier.isNotEmpty()) {
                val multiplierValue = multiplier.toFloat()
                val multipliedValue = progress * multiplierValue * 0.01 + multiplierValue
                val tipValue = progress
                val tip = findViewById<TextView>(R.id.tip)
                tip.text = "Tip: $tipValue %"
                val resultTextView = findViewById<TextView>(R.id.resultTextView)
                resultTextView.text = "Amount: $multipliedValue"
            }
        }
        base.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updateResult(seekBar.progress, s.toString())
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val multiplier = base.text.toString()
                updateResult(progress, multiplier)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }
}