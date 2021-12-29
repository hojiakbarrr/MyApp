package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private var textview: TextView ?=null
    private lateinit var editText: EditText
    private lateinit var editText1: EditText
    lateinit var button_plus: Button
    private lateinit var button_minus: Button
    private lateinit var button_multiplication: Button
    private lateinit var button_division: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView3)
        editText = findViewById(R.id.onenumber)
        editText1 = findViewById(R.id.twonumber)
        button_plus = findViewById(R.id.button3)
        button_minus = findViewById(R.id.button)
        button_multiplication = findViewById(R.id.button2)
        button_division = findViewById(R.id.button4)



        button_plus.setOnClickListener {

            if (editText.text.toString() == "" || editText1.text.toString() == ""){
                textview?.text = "Поля пустые!!!"
            }else {

                var one = editText.text.toString().toInt()
                var two = editText1.text.toString().toInt()

                val itog = one + two
                textview?.text = itog.toString()
            }
        }

        button_minus.setOnClickListener {

            if (editText.text.toString() == "" || editText1.text.toString() == ""){
                textview?.text = "Поля пустые!!!"
            }else {

                var one = editText.text.toString().toInt()
                var two = editText1.text.toString().toInt()

                val itog = one - two
                textview?.text = itog.toString()
            }
        }

        button_multiplication.setOnClickListener {

            if (editText.text.toString() == "" || editText1.text.toString() == ""){
                textview?.text = "Поля пустые!!!"
            }else {

                var one = editText.text.toString().toInt()
                var two = editText1.text.toString().toInt()

                val itog = one * two
                textview?.text = itog.toString()

            }
        }


        button_division.setOnClickListener {

            if (editText.text.toString() == "" || editText1.text.toString() == "") {
                textview?.text = "Поля пустые!!!"
            }else{

                var one = editText.text.toString().toDouble()
                var two = editText1.text.toString().toDouble()

                if (0.0 == two){
                    val itog = "На ноль и ниже, делить нельзя"
                    textview?.text = itog
                }else {
                    val itog = one / two
                    textview?.text = itog.toString()
                }
            }
        }






    }


}