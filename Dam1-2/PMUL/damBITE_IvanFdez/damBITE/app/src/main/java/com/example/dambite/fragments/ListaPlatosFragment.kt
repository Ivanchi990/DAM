package com.example.dambite.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dambite.R
import com.example.dambite.databinding.FragmentListaPlatosBinding
import com.example.dambite.entity.Plato
import com.example.dambite.recyclerview.PlatoRVAdapter
import com.example.dambite.rest.ListaDePlatosResponse
import com.example.dambite.rest.PlatoResponse
import com.example.dambite.rest.RetrofitInstance
import com.example.dambite.viewModel.FavoritosViewModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaPlatosFragment : Fragment()
{
    lateinit var binding: FragmentListaPlatosBinding
    private var listaPlatos: List<PlatoResponse> = mutableListOf<PlatoResponse>()
    private val favoritosViewModel: FavoritosViewModel by viewModels()
    private lateinit var listaPlatosAdapter: PlatoRVAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        val fragmentBinding = FragmentListaPlatosBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        initRecyclerView()

        binding.btnBuscar.setOnClickListener{
            buscarPlatos()
        }

        return fragmentBinding.root
    }

    fun initRecyclerView()
    {
        var recyclerView = binding.listaPlatosRV
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        listaPlatosAdapter = PlatoRVAdapter(listaPlatos = listaPlatos,
            perfilPlato = { plato -> perfilPlato(plato) },
            anadirFavorito = { plato -> anadirFavorito(plato) })

        recyclerView.adapter = listaPlatosAdapter
    }

    fun perfilPlato(plato: PlatoResponse)
    {
        Toast.makeText(requireContext(), "El plato seleccionado es ${plato.nombre} ", Toast.LENGTH_LONG).show()

        val bundle = Bundle().apply {
            putString("idPlato", plato.id)
        }

        val fragment = PerfilPlatoFragment().apply {
            arguments = bundle
        }
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun anadirFavorito(plato: PlatoResponse)
    {
        var existe = false

        for(p in favoritosViewModel.listaPlatosFavoritos.value!!)
        {
            if(plato.id == p.id)
            {
                existe = true
                break
            }
        }

        if(!existe)
        {
            favoritosViewModel.anadirPlato(Plato(plato.id, plato.nombre, plato.categoria, plato.area, plato.urlImagen))
        }
        else
        {
            Toast.makeText(requireContext(), "El plato ya está añadido", Toast.LENGTH_SHORT).show()
        }
    }


    fun buscarPlatos()
    {
        var texto = binding.tvBuscar.text.toString()

        if(!texto.isEmpty())
        {
            RetrofitInstance.api.getPlatosByName("/api/json/v1/1/search.php?s=$texto").enqueue(object : Callback<ListaDePlatosResponse> {
                override fun onResponse(
                    call: Call<ListaDePlatosResponse>,
                    response: Response<ListaDePlatosResponse>
                ) {
                    if (response.body() != null)
                    {
                        listaPlatosAdapter.listaPlatos = response.body()!!.meals
                        listaPlatosAdapter.notifyDataSetChanged()
                    }
                    else
                    {
                        return
                    }
                }

                override fun onFailure(call: Call<ListaDePlatosResponse>, t: Throwable)
                {
                    Log.d("TAG", t.message.toString())
                }
            })
        }
        else
        {
            Toast.makeText(requireContext(), "Tienes que escribir algo",  Toast.LENGTH_SHORT).show()
        }
    }
}