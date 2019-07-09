package com.sbpinilla.munugiros

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sbpinilla.munugiros.model.MenuModel
import kotlinx.android.synthetic.main.item_menu_giros.view.*

class MenuListAdapter(val context: Context,val items: List<MenuModel>,val isTwoPanel:Boolean,  val adapterOnClick : (MenuModel) -> Unit) :
    RecyclerView.Adapter<EmployeeViewHolder>() {

    var index = -1


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmployeeViewHolder {

        return EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_giros, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

        val menuModel = items.get(position)

        holder.view_id?.text = menuModel.id.toString()
        holder.view_name?.text = menuModel.nombre

        holder.itemView.setOnClickListener {
            index = position
            notifyDataSetChanged()
            adapterOnClick(menuModel)
        }
        if(isTwoPanel){

            if(index==position){

                holder.itemView.setBackgroundResource(R.color.colorPrimary)

            }else{

                holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))

            }
        }


    }

}


class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val view_id = view.txt_id
    val view_name = view.txt_nombre
}


