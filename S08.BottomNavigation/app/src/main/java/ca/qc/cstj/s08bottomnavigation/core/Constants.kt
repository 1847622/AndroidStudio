package ca.qc.cstj.s08bottomnavigation.core

object Constants {


    const val METEO_REFRESH_INTERVAL = 120000L
    const val METEO_API_KEY = "abbe675c5f6fde6bc84c0064025f656e"
    const val METEO_API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=${METEO_API_KEY}&units=metric"
    const val LOAD_FLAG_API = "https://flagcdn.com/h24/%s.png"
    const val TEMPERATURE_BREAKPOINT = 15

}