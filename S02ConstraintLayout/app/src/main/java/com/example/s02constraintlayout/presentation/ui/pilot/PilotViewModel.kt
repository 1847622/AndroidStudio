package com.example.s02constraintlayout.presentation.ui.pilot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.s02constraintlayout.core.notify
import com.example.s02constraintlayout.domain.models.Pilot

class PilotViewModel : ViewModel() {

    private val _pilot = MutableLiveData<Pilot>()

    val pilot : LiveData<Pilot> get() = _pilot

    init {
        _pilot.value = Pilot("OMG" , 10)
    }

    fun fly(revolution:Int , isTraining :Boolean) : Boolean{

        val pilotValue = _pilot.value!!

        return if(pilotValue.canFly()){
            pilotValue.fly(revolution, isTraining)
           // _pilot.value = pilotValue
            // la ligne en dessous pour refresh les informations vue sur l'écran , on repasse les mêmes informations pour les mettre a jour
            // _pilot.postValue(_pilot.value)
            _pilot.notify()
            true
        }else {
            false
        }
    }

    fun recharge() {
        _pilot.value!!.recharge()
        //_pilot.value = _pilot.value
        _pilot.notify()
    }


}