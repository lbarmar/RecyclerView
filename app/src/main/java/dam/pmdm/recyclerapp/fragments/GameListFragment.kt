package dam.pmdm.recyclerapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dam.pmdm.recyclerapp.R
import dam.pmdm.recyclerapp.adapters.GameRecyclerViewAdapter
import dam.pmdm.recyclerapp.databinding.GameListFragmentBinding
import dam.pmdm.recyclerapp.models.GameData
import dam.pmdm.recyclerapp.utils.RetrofitInstance
import dam.pmdm.recyclerapp.utils.putGameData
import kotlinx.coroutines.launch

class GameListFragment: Fragment() {

    private lateinit var binding: GameListFragmentBinding
    private lateinit var gamesAdapter: GameRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameListFragmentBinding.inflate(inflater, container, false)

//        Llenar lista con datos
        loadGames()

        return binding.root
    }

    private fun onGameClicked(gameData: GameData) {
        // Crear un nuevo Bundle
        val bundle = Bundle()
        bundle.putGameData("gameData", gameData)
        findNavController().navigate(R.id.gameDetailFragment, bundle)
    }

    // Método para cargar juegos
    private fun loadGames() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getGames()
                if (response.isSuccessful) {
                    response.body()?.let { gameResponse ->
                        setupRecyclerView(gameResponse.games)
                    }
                } else {
                    Log.e("API Error", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("Network Error", "Exception: $e")
            }
        }
    }

    private fun setupRecyclerView(games: List<GameData>) {
        binding.gamesRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        gamesAdapter = GameRecyclerViewAdapter(games, ::onGameClicked)
        binding.gamesRecyclerview.adapter = gamesAdapter
    }
}