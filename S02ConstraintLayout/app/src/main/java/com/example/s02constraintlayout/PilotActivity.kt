package com.example.s02constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.s02constraintlayout.databinding.ActivityPilotBinding
import com.example.s02constraintlayout.domain.models.Pilot

class PilotActivity : AppCompatActivity() {

    //Permettre d'accéder aux composant graphiques (Button , txtView , ... ) de l'interface
    private lateinit var binding: ActivityPilotBinding

    private val _pilot = Pilot("Bee Zoon", 10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Transforme et charge le xml en mémoire dans le binding
        binding = ActivityPilotBinding.inflate(layoutInflater)
        // Créer l'interface à patir du binding
        setContentView(binding.root)

        refreshUI()


        binding.btnStart.setOnClickListener() {
            if (_pilot.canFly()) {
                _pilot.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)

                refreshUI()
            } else {
                //TODO : Snackbar chez Raymond
            }

        }


    }

    private fun refreshUI(){
        with(binding) {
            txvPilotName.text = _pilot.name
            txvLevel.text = _pilot.level.toString()
            txvLife.text = _pilot.life.toString()
            txvShield.text = _pilot.shield.toString()
            txvEnergy.text = _pilot.energy.toString()
            txvCube.text = _pilot.cube.toString()

        }
    }


}