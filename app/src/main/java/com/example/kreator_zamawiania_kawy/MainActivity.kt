package com.example.kreator_zamawiania_kawy

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ilosc_text: TextView = findViewById(R.id.ilosc_text)
        val ilosc: SeekBar = findViewById(R.id.ilosc)

        ilosc_text.text = "${ilosc.progress}"

        ilosc.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                ilosc_text.text = "$progress"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


        val obrazek:ImageView = findViewById(R.id.obrazek)
        val zamow:Button = findViewById(R.id.zamow)
        val radioGroup: RadioGroup = findViewById(R.id.rodzaj)

        val images = mapOf(
            R.id.rodzaj_espresso to R.drawable.espresso,
            R.id.rodzaj_cappuccino to R.drawable.capuccino,
            R.id.rodzaj_latte to R.drawable.latte
        )

        zamow.setOnClickListener {

            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                val selectedImageResId = images[selectedRadioButtonId]
                if (selectedImageResId != null) {
                    obrazek.setImageResource(selectedImageResId)
                }
            }
        }




    }
}