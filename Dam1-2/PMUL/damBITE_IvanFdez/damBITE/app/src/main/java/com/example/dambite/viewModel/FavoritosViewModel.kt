package com.example.dambite.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dambite.MainActivity
import com.example.dambite.entity.Plato
import com.example.dambite.opensqlite.MiBDOpenHelper

class FavoritosViewModel : ViewModel()
{
    private var dbHelper = MiBDOpenHelper(MainActivity.context, null)

    var listaPlatosFavoritos: MutableLiveData<MutableList<Plato>> = MutableLiveData()

    init {
        listaPlatosFavoritos.value = dbHelper!!.obtenerPlatos()
    }

    fun setDBHelper(miBDOpenHelper: MiBDOpenHelper)
    {
        dbHelper = miBDOpenHelper
    }

    fun anadirPlato(plato: Plato)
    {
        listaPlatosFavoritos.value!!.add(plato)
        dbHelper.anadirPlato(plato)
    }

    fun eliminarProducto(id: String)
    {
        for(p in listaPlatosFavoritos.value!!)
        {
            if(p.id == id)
            {
                listaPlatosFavoritos.value!!.remove(p)
                break
            }
        }

        dbHelper.eliminarPlato(id)
    }
}