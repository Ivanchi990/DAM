package com.example.dambite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dambite.R
import com.example.dambite.databinding.FragmentFavoritosBinding
import com.example.dambite.databinding.FragmentInicioBinding

class InicioFragment : Fragment()
{
    private var binding: FragmentInicioBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val fragmentBinding = FragmentInicioBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        fragmentBinding.btnBuscar.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragment = ListaPlatosFragment()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        fragmentBinding.btnFavorito.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragment = FavoritosFragment()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return fragmentBinding.root
    }
}