package com.example.s02constraintlayout.presentation.ui.pilot

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import com.example.s02constraintlayout.R
import com.example.s02constraintlayout.databinding.ActivityPilotBinding
import com.example.s02constraintlayout.domain.models.Pilot
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class PilotActivity : AppCompatActivity() {

    //Permettre d'accéder aux composant graphiques (Button , txtView , ... ) de l'interface
    private lateinit var binding: ActivityPilotBinding
    private val viewModel : PilotViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Transforme et charge le xml en mémoire dans le binding
        binding = ActivityPilotBinding.inflate(layoutInflater)
        // Créer l'interface à patir du binding
        setContentView(binding.root)

        viewModel.pilot.observe(this) {
            with(binding) {
                txvPilotName.text = it.name
                txvLevel.text = getString(R.string.level, it.level)
                txvLife.text = it.life.toString()
                txvShield.text = it.shield.toString()
                txvEnergy.text = it.energy.toString()
                txvCube.text = it.cube.toString()
            }


            //refreshUI()


            binding.btnStart?.setOnClickListener {
                if(!viewModel.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)){
                    Snackbar.make(binding.root,getString(R.string.low_resources), Snackbar.LENGTH_INDEFINITE)
                        .setAction(getString(R.string.msgRecharge)){
                            viewModel.recharge()

                        }
                        .show()
                }

            }

        }

    }
}



/* Animation pour le bouton
 if (_pilot.canFly()) {
               binding.btnStart.isEnabled = false
               _pilot.fly(binding.sldRevolution.value.toInt(), binding.swtTraining.isChecked)

               val layoutParams = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
               val startAngle = layoutParams.circleAngle
               val endAngle = startAngle - 360
               val animation = ValueAnimator.ofFloat(startAngle,endAngle)


               animation.repeatCount = binding.sldRevolution.value.toInt() - 1
               animation.duration = Random.nextLong(1500,3000)
               animation.interpolator = LinearInterpolator()

               animation.addUpdateListener {
                   val animatedValue = it.animatedValue as Float
                   val layoutParamsAnimation = binding.imvRocket.layoutParams as ConstraintLayout.LayoutParams
                   layoutParamsAnimation.circleAngle = animatedValue
                   binding.imvRocket.layoutParams = layoutParamsAnimation
                   binding.imvRocket.rotation = animatedValue - 90

               }

               animation.doOnEnd {
                   binding.btnStart?.isEnabled = true
                   refreshUI()

               }

               animation.start()


           } else {

           }
*/