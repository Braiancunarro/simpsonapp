package com.aristidevs.simpsonapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aristidevs.simpsonapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PersonajeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.root

        adapter = PersonajeAdapter()

        binding.rvBusqueda.layoutManager = LinearLayoutManager(context)
        binding.rvBusqueda.adapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://apisimpsons.fly.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(SimpsonApiService::class.java)


        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (!query.isNullOrBlank()) {
                    buscarPersonajes(apiService, query)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })


    }

    private fun buscarPersonajes(apiService: SimpsonApiService, query: String) {
        val call = apiService.buscarPersonajes(query)
        call.enqueue(object : Callback<List<Personaje>> {
            override fun onResponse(
                call: Call<List<Personaje>>,
                response: Response<List<Personaje>>
            ) { if (response.isSuccessful) {
                val personajes = response.body()
                if (personajes != null) {  }
                }

            }

            override fun onFailure(call: Call<List<Personaje>>, t: Throwable) {}

        }


        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
