package dam.pmdm.recyclerapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dam.pmdm.recyclerapp.R
import dam.pmdm.recyclerapp.adapters.GameRecyclerViewAdapter
import dam.pmdm.recyclerapp.databinding.GameListFragmentBinding
import dam.pmdm.recyclerapp.getGameData
import dam.pmdm.recyclerapp.models.GameData
import dam.pmdm.recyclerapp.putGameData

class GameListFragment: Fragment() {

    private lateinit var binding: GameListFragmentBinding
    private lateinit var games: MutableList<GameData>
    private lateinit var gamesAdapter: GameRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GameListFragmentBinding.inflate(inflater, container, false)

        // Definir el LayoutManager, que en este caso será un LinearLayoutManager para una lista vertical
        binding.gamesRecyclerview.layoutManager = LinearLayoutManager(requireContext())


        // Asignar el adaptador al RecyclerView
        loadGames()
        gamesAdapter = GameRecyclerViewAdapter(games, ::onGameClicked)
        binding.gamesRecyclerview.adapter = gamesAdapter

        return binding.root
    }

    private fun onGameClicked(gameData: GameData) {
        // Crear un nuevo Bundle
        val bundle = Bundle()
        bundle.putGameData("gameData", gameData)
        findNavController().navigate(R.id.gameDetailFragment, bundle)
    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private fun loadGames() {
        games = mutableListOf<GameData>()

        // Llenar la lista con datos de videojuegos
        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/71uS8Ra1aGL._AC_UF894,1000_QL80_.jpg", // Reemplaza con la ruta de la imagen
                name = "Super Mario Bros. Wonder",
                releaseYear = 2023,
                description = "Un juego de plataformas en un mundo vibrante lleno de sorpresas.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/71C9pOGlKtL.jpg", // Reemplaza con la ruta de la imagen
                name = "Mario Kart 8 Deluxe",
                releaseYear = 2017,
                description = "Una versión mejorada de Mario Kart 8 con un modo de batalla renovado.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/81CbYA2Gt3L._AC_UF894,1000_QL80_.jpg", // Reemplaza con la ruta de la imagen
                name = "Super Mario 3D World + Bowser's Fury",
                releaseYear = 2021,
                description = "Aventura cooperativa en 3D con una misión en el mundo abierto de Bowser's Fury.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/81d3KS1-6OL.jpg", // Reemplaza con la ruta de la imagen
                name = "Super Mario Maker 2",
                releaseYear = 2019,
                description = "Diseña y comparte tus propios niveles de Mario en esta secuela.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/81drkVN7GRL._AC_UF1000,1000_QL80_.jpg", // Reemplaza con la ruta de la imagen
                name = "Super Mario Odyssey",
                releaseYear = 2017,
                description = "Mario debe rescatar a la Princesa Peach utilizando su compañero, Cappy.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/71FxEVBYddL._AC_UF1000,1000_QL80_.jpg", // Reemplaza con la ruta de la imagen
                name = "Super Mario All-Stars",
                releaseYear = 2021,
                description = "Colección remasterizada de los clásicos juegos de Mario.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/81XdRd9UNZL.jpg",
                name = "Super Mario Party",
                releaseYear = 2018,
                description = "Un juego de fiesta con tableros virtuales y mini-juegos.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/91bAhoyCcUL.jpg",
                name = "Mario Golf: Super Rush",
                releaseYear = 2021,
                description = "Un enfoque divertido del golf con personajes de Mario.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://media.vandal.net/m/85340/paper-mario-the-origami-king-20205141527529_1.jpg",
                name = "Paper Mario: The Origami King",
                releaseYear = 2020,
                description = "Mario debe detener al Rey Origami en esta aventura de rol.",
                platforms = "Nintendo Switch"
            )
        )

        games.add(
            GameData(
                image = "https://m.media-amazon.com/images/I/81zgWwSnVfL.jpg",
                name = "Mario + Rabbids Sparks of Hope",
                releaseYear = 2022,
                description = "Mario y los Rabbids deben salvar a los Sparks en esta aventura.",
                platforms = "Nintendo Switch"
            )
        )
    }
}