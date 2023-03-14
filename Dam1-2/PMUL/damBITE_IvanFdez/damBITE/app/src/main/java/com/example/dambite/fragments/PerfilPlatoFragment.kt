package com.example.dambite.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.dambite.databinding.FragmentPerfilPlatoBinding
import com.example.dambite.entity.Plato
import com.example.dambite.rest.ListaDePlatosResponse
import com.example.dambite.rest.PlatoResponse
import com.example.dambite.rest.RetrofitInstance
import com.example.dambite.viewModel.FavoritosViewModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PerfilPlatoFragment : Fragment()
{

    private lateinit var binding: FragmentPerfilPlatoBinding
    private var idPlato: String? = null
    private val favoritosViewModel: FavoritosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        val fragmentBinding = FragmentPerfilPlatoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        arguments?.let { bundle ->
            idPlato = bundle.getString("idPlato")
        }

        mostrarPlato()

        return fragmentBinding.root
    }

    private fun mostrarPlato()
    {
        RetrofitInstance.api.getPlatoById("/api/json/v1/1/lookup.php?i=$idPlato")
            .enqueue(object : Callback<ListaDePlatosResponse> {
            override fun onResponse(
                call: Call<ListaDePlatosResponse>,
                response: Response<ListaDePlatosResponse>
            ) {
                if (response.body() != null)
                {
                    val plato = response.body()!!.meals[0]

                    binding.tvNombrePlato.text = plato.nombre

                    Picasso.with(binding.ivPlato.context).load(plato.urlImagen)
                        .fit().centerCrop().into(binding.ivPlato)

                    binding.textCategoriaPlato.text = plato.categoria
                    binding.textArea.text = plato.area
                    binding.tvDescripcion.text = plato.instrucciones
                    binding.tvTags.text = plato.etiquetas

                    comprobarLike()
                }
                else
                {
                    return
                }
            }

            override fun onFailure(call: Call<ListaDePlatosResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }

    private fun comprobarLike()
    {
        val boton = binding.btnFavorito

        for(plato in favoritosViewModel.listaPlatosFavoritos.value!!)
        {
            if(plato.id == idPlato)
            {
                boton.text = "unlike"
                break
            }
        }
    }
}