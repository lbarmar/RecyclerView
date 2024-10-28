package dam.pmdm.recyclerapp.utils

import android.os.Bundle
import dam.pmdm.recyclerapp.models.GameData

// Función para agregar GameData a un Bundle
fun Bundle.putGameData(key: String, gameData: GameData) {
    putString("$key.image", gameData.image)
    putString("$key.name", gameData.name)
    putInt("$key.releaseYear", gameData.releaseYear)
    putString("$key.description", gameData.description)
    putString("$key.platforms", gameData.platforms)
}

// Función para recuperar GameData de un Bundle
fun Bundle.getGameData(key: String): GameData {
    val image = getString("$key.image") ?: ""
    val name = getString("$key.name") ?: ""
    val releaseYear = getInt("$key.releaseYear", 0)
    val description = getString("$key.description") ?: ""
    val platforms = getString("$key.platforms") ?: ""

    return GameData(image, name, releaseYear, description, platforms)
}