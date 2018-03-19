package com.gelves.uriel.pocketmonsters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
private val url = "https://pokeapi.co/api/v2/pokemon/"
private var monList : ArrayList<Mon>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rView.layoutManager = LinearLayoutManager(this)


        btnSearch.setOnClickListener {
            val pokename = editSearch.text.toString()
            progBar.visibility = View.VISIBLE

            doAsync {
                val resultJson = URL(url + pokename).readText()

                val jsonObject = JSONObject(resultJson)
                val Pokemonname = (jsonObject.getString("name"))
                val weight = (jsonObject.getString("weight"))
                val ability = jsonObject.getJSONArray("abilities").getJSONObject(0).getJSONObject("ability").getString("name")
                val type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name")
                val sprites = jsonObject.getJSONObject("sprites").getString("front_default")
                val height = (jsonObject.getString("height"))
         uiThread {
             monList = ArrayList()

                            rView.adapter = MonAdapter(monList)



                    monList?.add(Mon(Pokemonname,sprites,height,weight,ability,type ))




                }
                progBar.visibility = View.INVISIBLE
            }
        }

    }


}