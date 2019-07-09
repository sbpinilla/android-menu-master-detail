package com.sbpinilla.munugiros

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.sbpinilla.munugiros.fragment.EnviarGirosFragment
import com.sbpinilla.munugiros.fragment.PagoGirosFragment
import com.sbpinilla.munugiros.model.MenuModel
import kotlinx.android.synthetic.main.list_menu_giros.*


class ListMenuGiros : AppCompatActivity() {


    var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_menu_giros)

        Log.d("LIST", "onCreate")

        if (container_menu_giros != null) {

            mTwoPane = true


        }

        setupRecyclerView(rvListMenu)

    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {

        Log.d("LIST", "setupRecyclerView")

        val listMenu = arrayListOf<MenuModel>()

        listMenu.add(MenuModel(1, "Envio giros 1"))
        listMenu.add(MenuModel(2, "Pago giros 2"))
        listMenu.add(MenuModel(3, "Menu 3"))

        val adapter = MenuListAdapter(this, listMenu, mTwoPane, { doClick(it) })
        adapter.index = 0
        recyclerView.adapter = adapter

        if (mTwoPane) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_menu_giros, EnviarGirosFragment())
                .commit()

        }


    }

    private fun doClick(item: MenuModel) {

        if (mTwoPane) {

            var content: Fragment? = null

            when (item.id) {
                1 -> content = EnviarGirosFragment()
                2 -> content = PagoGirosFragment()

            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_menu_giros, content!!)
                .commit()

        } else {

            val intent = Intent(this, ContainerGironActivity::class.java).apply {
                putExtra("MENU_ITEM", item)

            }

            startActivity(intent)

        }

        Log.d("LIST", "$item")

    }
}
