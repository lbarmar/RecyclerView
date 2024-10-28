package dam.pmdm.recyclerapp.utils

import dam.pmdm.recyclerapp.models.GameResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("games") // Cambia la ruta según tu configuración de Mock Server
    suspend fun getGames(): Response<GameResponse>
}