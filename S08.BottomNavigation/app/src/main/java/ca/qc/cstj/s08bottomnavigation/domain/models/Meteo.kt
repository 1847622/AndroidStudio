package ca.qc.cstj.s08bottomnavigation.domain.models

data class Meteo(
    val city: String,
    val flag: String,
    val temperature: Double,
    val weather: String,
    val timestamp: Int,
    val timeZone : Int,
    val latitude: Double,
    val longitude: Double
) {

}