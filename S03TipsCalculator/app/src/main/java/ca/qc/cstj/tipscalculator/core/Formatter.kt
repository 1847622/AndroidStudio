package ca.qc.cstj.tipscalculator.core

import java.text.NumberFormat

object Formatter {

    fun toMoneyFormat(amount:Double) : String{

        val numberFormat = NumberFormat.getCurrencyInstance()
        return numberFormat.format(amount)
    }

}