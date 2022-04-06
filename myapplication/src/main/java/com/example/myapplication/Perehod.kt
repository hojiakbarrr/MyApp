package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.ArrayList as ArrayList1

class Perehod : AppCompatActivity() {

    private var doll: TextView? = null
    private var eur: TextView? = null
    private var rus: TextView? = null

    private var itog: TextView? = null
    private var itog1: TextView? = null
    private var itog2: TextView? = null

    //    lateinit var preferences: SharedPreferences
    var pref: SharedPreferences? = null

    lateinit var oper: ArrayList1<String>
    lateinit var oper11: ArrayList1<String>
    private var itog3: TextView? = null
    private var simpleDateFormat: SimpleDateFormat? = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perehod)

        preferences = getSharedPreferences("pref", MODE_PRIVATE)
        editor = preferences.edit()


///*/*/*/*/*/*//////////////////******
        itog = findViewById(R.id.textView8)
        itog1 = findViewById(R.id.textView7)
        itog2 = findViewById(R.id.textView4)

        val euro = intent.extras?.get("euro")
        val dol = intent.extras?.get("usd")
        val rub = intent.extras?.get("rus")

        itog?.text = rub.toString()
        itog1?.text = euro.toString()
        itog2?.text = dol.toString()

//*/*/*/*/*/*/выичсления
        doll = findViewById(R.id.textView11)
        eur = findViewById(R.id.textView10)
        rus = findViewById(R.id.textView9)

        val one = intent.extras?.get("one")
        val two = intent.extras?.get("two")
        val three = intent.extras?.get("three")

        doll?.text = one.toString()
        eur?.text = two.toString()
        rus?.text = three.toString()

        itog3 = findViewById(R.id.textView13)

//*/*/*/**/*/*/*/*/*/*///итог
        var list = getList()

        for (i in list){
            Log.i("myTag",i)
            itog3?.append(i + "\n")
        }

//        for (i in 1..6){
//            var time = intent.extras?.get("date"+i);
//            if(time!= null){
//                oper.addAll(listOf("\n " + time.toString()));
//            }
//        }
//        var меняется
//        val не меняется


        findViewById<ImageView>(R.id.clear).setOnClickListener{

//            editor.remove(list.toString())
//            editor.remove("LIST")
            editor.clear()
            editor.commit()
            editor.apply()
//            var list = getList()
//            val gson = Gson()
//            val json = gson.toJson(list)//converting list to Json
//            for (i in list){
//                Log.i("myTag",i)
//                itog3?.text = ""





//            var listString = getList()
//            editor.clear()
//            editor.apply()

//            list.clear()
////            listString = (listOf("")) as ArrayList<String>
//            if (list.isNullOrEmpty()){
//                itog3?.clearComposingText()
//            }
//            editor.clear()
//            setLists(list.toString())


        }




    }

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
    //saving list in Shared Preference
    fun setLists(list: String){
        val gson = Gson()
        val json = gson.toJson(list)//converting list to Json
        editor.putString("LIST",json)
        editor.commit()
    }


}