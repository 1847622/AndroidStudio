package ca.qc.cstj.s06remotedatasource.data.repositories

import ca.qc.cstj.s06remotedatasource.core.Contants
import ca.qc.cstj.s06remotedatasource.core.LoadingResource
import ca.qc.cstj.s06remotedatasource.core.Resource
import ca.qc.cstj.s06remotedatasource.data.datasources.FuelPlanetDataSource
import ca.qc.cstj.s06remotedatasource.domain.models.Planet
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// axios = fuel

class FuelPlanetRepository {

    private val planetDataSource = FuelPlanetDataSource()

    // Retrouve les planètes sans mise a jour
    suspend fun retrieveAll(): Resource<List<Planet>> {
        return try {
             Resource.Success(planetDataSource.retrieveAll())
        }catch (ex: Throwable){
             Resource.Error(ex,"Erreur Serveur")
        }
    }

    // Retrouver les planètes avec une mise à jour régulière
    suspend fun retrieveAllWithUpdate() : Flow<Resource<List<Planet>>> {
        return flow {
           while (true){
               try {
                   emit(Resource.Success(planetDataSource.retrieveAll()))
               }catch (ex: Throwable){
                   emit(Resource.Error(ex,"Erreur Serveur"))
               }
               delay(Contants.RefreshRates.PLANETS_REFRESH_RATE)
           }
        }

    }

    suspend fun retrieveAllWithLoading(): Flow<LoadingResource<List<Planet>>> {
        return flow {
            while (true){
                try {
                    emit(LoadingResource.Loading())
                    delay(1500)
                    emit(LoadingResource.Success(planetDataSource.retrieveAll()))
                }catch (ex: Throwable){
                    emit(LoadingResource.Error(ex,"Erreur Serveur"))
                }
                delay(Contants.RefreshRates.PLANETS_REFRESH_RATE)
            }
        }
    }


}