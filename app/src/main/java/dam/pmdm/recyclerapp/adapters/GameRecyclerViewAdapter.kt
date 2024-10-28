package dam.pmdm.recyclerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.recyclerapp.activities.MainActivity
import dam.pmdm.recyclerapp.databinding.GameCardviewBinding
import dam.pmdm.recyclerapp.models.GameData

class GameRecyclerViewAdapter(
    private val items: List<GameData>,
    private val onGameClicked: (GameData) -> Unit
) : RecyclerView.Adapter<GameViewHolder>() {

    // Método que crea el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding =
            GameCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    // Método que enlaza datos al ViewHolder
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currentItem = items[position]

        holder.bind(currentItem)

        // Manejar el evento de clic
        holder.itemView.setOnClickListener {
            onGameClicked(currentItem)
        }
    }

    override fun getItemCount(): Int = items.size

}

