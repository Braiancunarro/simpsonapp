package com.aristidevs.simpsonapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aristidevs.simpsonapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofit = getretrofit
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

val getretrofit = Retrofit.Builder()
    .baseUrl("https://apisimpsons.fly.dev/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val simpsonApiService = retrofit.create(SimpsonApiService::class.java)

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}
