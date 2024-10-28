package dam.pmdm.recyclerapp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dam.pmdm.recyclerapp.databinding.GameCardviewBinding
import dam.pmdm.recyclerapp.models.GameData

class GameViewHolder(private val binding: GameCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GameData) {
        Picasso.get()
            .load(item.image)
            .into(binding.image);
        binding.name.text = item.name;
        binding.releaseYear.text = item.releaseYear.toString();
        binding.executePendingBindings();
    }
}

