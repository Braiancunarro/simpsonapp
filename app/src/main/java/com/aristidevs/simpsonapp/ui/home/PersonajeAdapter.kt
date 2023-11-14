package com.aristidevs.simpsonapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.simpsonapp.R
import com.aristidevs.simpsonapp.databinding.ItemPersonajeBinding
import com.squareup.picasso.Picasso


class PersonajeAdapter {
    class PersonajeAdapter : RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {

        private var personajes: List<detallePersonajes> = listOf()

        fun setPersonajes(personajes: List<detallePersonajes>) {
            this.personajes= personajes
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent, false)
            return PersonajeViewHolder(view)
        }

        override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
            holder.bind(personajes[position])
        }

        override fun getItemCount(): Int = personajes.size

        class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val binding = ItemPersonajeBinding.bind(itemView)

            fun bind(personaje: detallePersonajes) {
                binding.tvNombre.text = personaje.nombre
                binding.tvHistoria.text = personaje.historia
                binding.tvEstado.text = personaje.estado
                binding.tvGenero.text = personaje.genero
                binding.tvOcupacion.text = personaje.ocupacion
                Picasso.get().load(personaje.imagen).into(binding.ivImagen)
            }
        }
    }
}