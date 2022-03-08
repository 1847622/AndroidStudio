package ca.qc.cstj.s05localdatasource.core

import android.widget.ImageView

fun ImageView.loadFromResource(imageName : String){

    // this = ImageView
    val imageId = this.resources.getIdentifier(imageName,"drawable",this.context.packageName)
    this.setImageResource(imageId)
}