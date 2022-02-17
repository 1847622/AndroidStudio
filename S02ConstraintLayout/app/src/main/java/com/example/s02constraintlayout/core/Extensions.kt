package com.example.s02constraintlayout.core

import androidx.lifecycle.MutableLiveData

fun String.laMethodeOlivier() : String{
    return "Olivier"
}


fun <T> MutableLiveData<T>.notify(){
    this.value = this.value
}