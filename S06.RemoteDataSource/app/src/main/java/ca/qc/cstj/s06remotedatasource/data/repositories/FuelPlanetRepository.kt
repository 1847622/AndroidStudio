package ca.qc.cstj.s06remotedatasource.data.repositories

import ca.qc.cstj.s06remotedatasource.core.Resource
import ca.qc.cstj.s06remotedatasource.data.datasources.FuelPlanetDataSource
import ca.qc.cstj.s06remotedatasource.domain.models.Planet

// axios = fuel

class FuelPlanetRepository {

    private val planetDataSource = FuelPlanetDataSource()

    suspend fun retrieveAll(): Resource<List<Planet>> {
        return try {
             Resource.Success(planetDataSource.retrieveAll())
        }catch (ex: Throwable){
             Resource.Error(ex,"Erreur Serveur")
        }
    }

}