package com.gelves.uriel.pocketmonsters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.monsters.view.*

/**
 * Created by Uyi on 3/8/2018.
 */
class MonAdapter(val pokemons: ArrayList<Mon>?): RecyclerView.Adapter<MonAdapter.CustomViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):

            CustomViewHolder = CustomViewHolder(LayoutInflater.from(parent?.context)

            .inflate(R.layout.monsters,parent,false))



    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {





        val pokemon = pokemons!![position]

        holder?.mon_nameQ?.text = pokemon.name

        holder?.mon_heightQ?.text = pokemon.height

        holder?.mon_weightQ?.text = pokemon.weight

        holder?.mon_abilityQ?.text = pokemon.ability

        holder?.mon_typeQ?.text = pokemon.type





        /*     for (i in 0 until pokemon.abilities.size)

                 holder?.tvabilities?.text = pokemon.abilities[i].ability.name*/



        Picasso.with(holder?.itemView?.context).load(pokemon.sprite).into(holder?.mon_imgQ)



    }



    override fun getItemCount(): Int = pokemons!!.size







    class CustomViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val mon_imgQ = view.mon_img
        val mon_heightQ = view.mon_height
        val mon_weightQ = view.mon_weight
        val mon_abilityQ = view.mon_ability
        val mon_nameQ = view.mon_name
        val mon_typeQ = view.mon_type





    }





}