package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity2 : AppCompatActivity() {
    private var temp: Boolean = true
    private var temp11: Boolean = true
    private lateinit var button: Button
    private lateinit var dollar: EditText
    private lateinit var euro: EditText
    private lateinit var ruble: EditText
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button = findViewById(R.id.calculate)
        dollar = findViewById(R.id.dollar)
        euro = findViewById(R.id.euro)
        ruble = findViewById(R.id.ruble)

        preferences = getSharedPreferences("pref", MODE_PRIVATE)
        editor = preferences.edit()
        var listString = getList();
        val intent = Intent(this@MainActivity2, Perehod::class.java)

        findViewById<ImageView>(R.id.imageView2).setOnClickListener {
            if (temp){
            temp = false
            findViewById<TextView>(R.id.textView2).text = "KGZ -> USD"
            }
            else{
                temp = true
                findViewById<TextView>(R.id.textView2).text = "USD -> KGZ"
            }
        }
////*/*/*/*/*/*/*/*/*/
        findViewById<ImageView>(R.id.imageView4).setOnClickListener {

            if (temp){
                temp = false
                findViewById<TextView>(R.id.textView5).text = "KGZ -> RUS"
            }else{

                temp = true
                findViewById<TextView>(R.id.textView5).text = "RUS -> KGZ"
            }

        }
        ////*/*/*/*/*/*/*/*/*/

        findViewById<ImageView>(R.id.imageView6).setOnClickListener {
            if (temp){

                temp = false
                findViewById<TextView>(R.id.textView6).text = "KGZ -> EURO"
            }else{

                temp = true
                findViewById<TextView>(R.id.textView6).text = "EURO -> KGZ"
            }

        }
        ///*/*/*/*/*/*/*//*/*/


        button.setOnClickListener {

            editor = preferences.edit()

            val currentDate: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            val currentTime: String = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())



            if (!temp) {
                if (dollar.text.toString() == "") {
                    intent.putExtra("one", "")
                    intent.putExtra("usd","KGZ -> USD")
                } else {
                    val dol = dollar.text.toString().toInt() * 0.012
                    var xy = dol.toString() + " долларов"
                    intent.putExtra("one", xy)
                    intent.putExtra("usd","KGZ -> USD")
                    val we = dol.toString() + " (KGZ -> USD) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date1", we)
                    listString= (listOf(we) + listString) as ArrayList<String>

                }
            } else {
                if (dollar.text.toString() == "") {
                    intent.putExtra("one", "")
                    intent.putExtra("usd","USD -> KGZ")
                } else {

                    var dol = dollar.text.toString().toInt() * 84.80
                    var xy = dol.toString() + " сом"
                    intent.putExtra("one", xy)
                    intent.putExtra("usd","USD -> KGZ")
                    val we = dol.toString() + " (USD -> KGZ) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date2", we)
                    listString= (listOf(we) + listString) as ArrayList<String>

                }
            }

//*/*/*/*/*/*/*/**/*/*/*
            if (!temp) {
                if (euro.text.toString() == "") {
                    intent.putExtra("two", "")
                    intent.putExtra("euro","KGZ -> EURO")
                } else {
                    var euro = euro.text.toString().toInt() * 0.010
                    var xy = euro.toString() + " евро"
                    intent.putExtra("two", xy)
                    intent.putExtra("euro","KGZ -> EURO")
                    val we = euro.toString() + " (KGZ -> EURO) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date3", we)
                    listString= (listOf(we) + listString) as ArrayList<String>


                }
            } else {
                if (euro.text.toString() == "") {
                    intent.putExtra("two", "")
                    intent.putExtra("euro","EURO -> KGZ")
                } else {
                    var euro = euro.text.toString().toInt() * 96
                    var xy = euro.toString() + " сом"
                    intent.putExtra("two", xy)
                    intent.putExtra("euro","EURO -> KGZ")
                    val we = euro.toString() + " (EURO -> KGZ) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date4", we)
                    listString= (listOf(we) + listString) as ArrayList<String>
                }
            }

//*/*/*/*/***//**/*/
            if (!temp) {
                if (ruble.text.toString() == "") {
                    intent.putExtra("three", "")
                    intent.putExtra("rus","KGZ -> RUS")
                } else {
                    var ruble = ruble.text.toString().toInt() * 0.87
                    var xy = ruble.toString() + " руб"
                    intent.putExtra("three", xy)
                    intent.putExtra("rus","KGZ -> RUS")
                    val we = ruble.toString() + " (KGZ -> RUS) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date5", we)
                    listString= (listOf(we) + listString) as ArrayList<String>
                }
            } else {
                if (ruble.text.toString() == "") {
                    intent.putExtra("three", "")
                    intent.putExtra("rus","RUS -> KGZ")
                } else {
                    var ruble = ruble.text.toString().toInt() * 1.15
                    var xy = ruble.toString() + " сом"
                    intent.putExtra("three", xy)
                    intent.putExtra("rus","RUS -> KGZ")
                    val we = ruble.toString() + " (RUS -> KGZ) " + " " + currentDate + " " + currentTime
                    intent.putExtra("date6", we)
                    listString= (listOf(we) + listString) as ArrayList<String>

                }
            }
//            intent.putExtra("list", listString);
            setLists(listString)
            startActivity(intent)
        }



    }
    //saving list in Shared Preference
    fun setLists(list:ArrayList<String>){
        val gson = Gson()
        val json = gson.toJson(list)//converting list to Json
        editor.putString("LIST",json)
        editor.commit()
    }
    //getting the list from shared preference
    fun getList():ArrayList<String>{
        val gson = Gson()
        val json = preferences.getString("LIST",null)
        val type = object : TypeToken<ArrayList<String>>(){}.type//converting the json to list


        if(json == null || json == "null"){
             return ArrayList<String>()
        }

        try {
            var list: ArrayList<String> = gson.fromJson(json, type);
            return list//returning the list
        }
        catch (e: Exception){
            return ArrayList<String>()
        }

    }

}
