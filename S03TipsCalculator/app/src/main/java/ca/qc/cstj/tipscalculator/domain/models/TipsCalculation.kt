package ca.qc.cstj.tipscalculator.domain.models

import ca.qc.cstj.tipscalculator.core.Constants

class TipsCalculation(private val subTotal: Double,private val tipsPercent: Int) {

    val tipsAmount = subTotal * ( tipsPercent / Constants.PERCENT)
    val TPS = subTotal * Constants.TPS
    val TVQ = subTotal * Constants.TVQ
    val total = subTotal + TPS + TVQ + tipsAmount



}