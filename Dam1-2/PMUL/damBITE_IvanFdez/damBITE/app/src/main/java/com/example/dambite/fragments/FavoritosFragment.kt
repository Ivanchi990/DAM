package com.example.dambite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dambite.R
import com.example.dambite.databinding.FragmentFavoritosBinding
import com.example.dambite.entity.Plato
import com.example.dambite.recyclerview.FavoritosRVAdapter
import com.example.dambite.viewModel.FavoritosViewModel

class FavoritosFragment : Fragment() {

    private lateinit var binding: FragmentFavoritosBinding
    private lateinit var favoritosAdapter: FavoritosRVAdapter
    private val favoritosViewModel: FavoritosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFavoritosBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        iniciarRecycler()

        return fragmentBinding.root
    }

    private fun iniciarRecycler()
    {
        val recyclerView = binding.listaFavoritosRV
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        favoritosAdapter = FavoritosRVAdapter(favoritosViewModel.listaPlatosFavoritos.value!!,
            perfilPlato = { plato -> perfilPlato(plato) },
            eliminarFavorito = { plato -> eliminarFavorito(plato) })

        recyclerView.adapter = favoritosAdapter
    }

    fun perfilPlato(plato: Plato)
    {
        Toast.makeText(
            requireContext(), "El plato seleccionado es ${plato.nombre} ", Toast.LENGTH_LONG
        ).show()

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

    private fun eliminarFavorito(plato: Plato)
    {
        favoritosViewModel.eliminarProducto(plato.id)

        favoritosAdapter.listaPlatos = favoritosViewModel.listaPlatosFavoritos.value!!
        favoritosAdapter.notifyDataSetChanged()
    }
}