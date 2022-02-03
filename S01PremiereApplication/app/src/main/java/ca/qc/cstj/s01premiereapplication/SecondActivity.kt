package ca.qc.cstj.s01premiereapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast

const val MIN_VALUE = 0
const val MAX_VALUE = 100
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txvWelcome = findViewById<TextView>(R.id.txvWelcome)
        val nbPicker = findViewById<NumberPicker>(R.id.nbPicker)
        val btnVerifier = findViewById<TextView>(R.id.btnVerifier)

        txvWelcome.text = getString(R.string.deviner_le_nombre, intent.getStringExtra("EXTRA_SECOND_ACTIVITY_NAME"))

        nbPicker.minValue = MIN_VALUE
        nbPicker.maxValue = MAX_VALUE

        val theNumber = (0..100).random()
        


        btnVerifier.setOnClickListener {
            if(nbPicker.value == theNumber){

                Toast.makeText(this, getString(R.string.msgWinner), Toast.LENGTH_SHORT).show()

            }else if (nbPicker.value > theNumber){

                Toast.makeText(this, "Le nombre est plus petit", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Le nombre est plus grand", Toast.LENGTH_SHORT).show()
            }
        }

    }
    // Partie statique de la classe
    companion object {
        fun newIntent(context: Context, name: String) : Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("EXTRA_SECOND_ACTIVITY_NAME", name)
            return intent

        }
    }

}