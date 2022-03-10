package ca.qc.cstj.s05localdatasource.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// ICI C'EST COMME CA QUAND ON UTILISE ROOM ( SQL)
@Entity(tableName= "contacts")

data class Contact(
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name ="lastName") val lastName : String,
    @ColumnInfo(name = "isOnline") val isOnline : Boolean
    ){
    @PrimaryKey(autoGenerate = true) var idContact : Int = 0
    val fullName:String get() = "$firstName $lastName"
}