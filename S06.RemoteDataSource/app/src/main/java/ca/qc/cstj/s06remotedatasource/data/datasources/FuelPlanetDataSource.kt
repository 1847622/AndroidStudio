package ca.qc.cstj.s06remotedatasource.data.datasources

import ca.qc.cstj.s06remotedatasource.core.Contants
import ca.qc.cstj.s06remotedatasource.domain.models.Planet
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.github.kittinunf.result.Result
import org.json.JSONObject

class FuelPlanetDataSource {

    suspend fun retrieveAll() : List<Planet> {

        return withContext(Dispatchers.IO) {
            val(req,res,result) = Contants.PLANET_API_URL.httpGet().responseJson()



            when(result) {
                // Code dans la famille 200
                is Result.Success -> {
                    val planets = mutableListOf<Planet>()
                    val planetsJson = result.value.array()

                    for (i in 0 until planetsJson.length()) {
                        planets.add(deserializationPlanet(planetsJson.getJSONObject(i)))
                    }
                    planets

                }
                // Code dans les familles 400 et 500
                is Result.Failure -> {
                    throw result.error.exception
                }
            }


        }

    }

    private fun deserializationPlanet(PlanetJson: JSONObject): Planet {

        val name = PlanetJson.getString("name")
        val image = PlanetJson.getString("icon")
        val temperature = PlanetJson.getDouble("temperature")

        return Planet(name,image,temperature)
    }


}