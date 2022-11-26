package ar.edu.unlam.tallerapp.data

import PublicKey
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CharacterClient {

    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getAllCharacters(timestamp: Long, md5: String): CharactersResponse {
        val charactersResponse = httpClient.get{
                url("https://gateway.marvel.com/v1/public/characters")
                parameter("apikey", value = PublicKey)
                parameter("ts", timestamp)
                parameter("hash", md5)
            }.body<CharactersResponse>()
        return charactersResponse
    }
}