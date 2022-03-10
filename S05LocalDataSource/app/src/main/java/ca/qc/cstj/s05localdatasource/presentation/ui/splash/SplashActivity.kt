package ca.qc.cstj.s05localdatasource.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ActivitySplashBinding
import ca.qc.cstj.s05localdatasource.presentation.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    private val viewModel : SplashViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.user.observe(this){

            binding.txvUserName.text = it.fullName

            when(it.isOnline){
                true -> binding.imgUserIsOnline.setImageResource(R.drawable.ic_baseline_cloud_24)
                false -> binding.imgUserIsOnline.setImageResource(R.drawable.ic_baseline_cloud_off_24)
            }


            // Bas 2 txt box + switch
            binding.tilFirstName.editText!!.setText(it.firstName)
            binding.tilLastName.editText!!.setText(it.lastName)
            binding.swtOnline.isChecked = it.isOnline
        }

        binding.btnSave.setOnClickListener{
                val firstName = binding.tilFirstName.editText!!.text.toString()
                val lastName = binding.tilLastName.editText!!.text.toString()
                viewModel.save(firstName,lastName,binding.swtOnline.isChecked)
        }



        binding.btnOpen.setOnClickListener{
            startActivity(MainActivity.newIntent(this))
        }




    }
}