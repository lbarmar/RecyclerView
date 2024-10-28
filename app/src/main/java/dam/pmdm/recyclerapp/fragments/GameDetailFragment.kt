package dam.pmdm.recyclerapp.fragments


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import dam.pmdm.recyclerapp.databinding.GameDetailFragmentBinding
import dam.pmdm.recyclerapp.getGameData
import dam.pmdm.recyclerapp.models.GameData

class GameDetailFragment : Fragment() {

    private lateinit var binding: GameDetailFragmentBinding
    private lateinit var gameData: GameData


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameDetailFragmentBinding.inflate(inflater, container, false)

        arguments?.let { args ->
            gameData = args.getGameData("gameData")
            initializeViewWithData()
        }

        return binding.root
    }

    private fun initializeViewWithData() {
        Picasso.get()
            .load(gameData.image)
            .into(binding.image);
        binding.name.text = gameData.name;
        binding.releaseYear.text = gameData.releaseYear.toString();
        binding.platforms.text = gameData.platforms
        binding.description.text = gameData.description
    }

}