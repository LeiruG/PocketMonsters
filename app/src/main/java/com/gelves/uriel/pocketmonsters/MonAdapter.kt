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
class MonAdapter (val monList: ArrayList<Mon>): RecyclerView.Adapter<MonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.monsters, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return monList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val pokemon: Mon = monList[position]
        holder?.view?.mon_name?.text = pokemon.mon_name
        val pokemonImage = holder?.view?.mon_img
        Picasso.with(holder?.view?.context).load(pokemon.mon_sprite.pSprite).into(pokemonImage)
    }

    class ViewHolder (val view: View): RecyclerView.ViewHolder(view)
}