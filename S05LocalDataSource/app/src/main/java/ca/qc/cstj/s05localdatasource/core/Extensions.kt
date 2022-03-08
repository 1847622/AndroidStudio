package ca.qc.cstj.s05localdatasource.core

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

fun ImageView.loadFromResource(imageName : String){

    // this = ImageView
    val imageId = this.resources.getIdentifier(imageName,"drawable",this.context.packageName)
    this.setImageResource(imageId)
}

fun <VH: RecyclerView.ViewHolder>RecyclerView.Adapter<VH>.notifyAllItemChanged(){
    notifyItemRangeChanged(0,itemCount)
}