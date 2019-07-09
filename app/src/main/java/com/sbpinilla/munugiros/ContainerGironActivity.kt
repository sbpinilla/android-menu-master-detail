package com.sbpinilla.munugiros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.sbpinilla.munugiros.fragment.EnviarGirosFragment
import com.sbpinilla.munugiros.fragment.PagoGirosFragment
import com.sbpinilla.munugiros.model.MenuModel

class ContainerGironActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_giron)

        setupFragment()


    }

    private fun setupFragment() {

        intent.extras.let {

            var content: Fragment? = null

            val item = it?.get("MENU_ITEM") as MenuModel

            when(item.id){
                1 -> content = EnviarGirosFragment()
                2 -> content = PagoGirosFragment()

            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,content!!)
                .commit()

        }



    }
}
