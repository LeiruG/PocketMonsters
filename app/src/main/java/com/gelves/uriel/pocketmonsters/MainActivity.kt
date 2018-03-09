package com.gelves.uriel.pocketmonsters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
private val url = "https://pokeapi.co/api/v2/pokemon/"
private var monList = ArrayList<Mon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = VISIBLE

        for (i in 1 ..20){
            doAsync {
                val resultJson =  URL(url + i).readText()
                uiThread {
                    val jsonObj = JSONObject(resultJson)

                    val id = jsonObj.getInt("id")
                    val name = jsonObj.getString("name")
                    val sprites = jsonObj.getString("sprites")
                    val jsonObj2 = JSONObject(sprites)
                    val front_default = jsonObj2.getString("front_default")

                    monList.add(Mon(name, Sprites(front_default), id))

                    rView.adapter = MonAdapter(monList)
                    if(monList.size!=0){txtQ.text= "You have " + monList.size.toString() + " pokemons."}

                    if (monList.size == 20){progressBar.visibility = GONE}
                }
            }
        }

    }


}