package ca.qc.cstj.s05localdatasource.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// ICI C'EST COMME CA QUAND ON UTILISE ROOM ( SQL)
@Entity(tableName= "contacts")

data class Contact(
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name ="lastName") var lastName : String,
    @ColumnInfo(name = "isOnline") var isOnline : Boolean
    ){
    @PrimaryKey(autoGenerate = true) var idContact : Int = 0
    val fullName:String get() = "$firstName $lastName"
}