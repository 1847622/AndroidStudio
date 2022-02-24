package ca.qc.cstj.s05localdatasource.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.qc.cstj.s05localdatasource.data.repositories.ContactRepository
import ca.qc.cstj.s05localdatasource.domain.models.Contact

class MainViewModel : ViewModel() {

    private val planetRepository = ContactRepository()


    private val _contact = MutableLiveData<List<Contact>>()
    val planets : LiveData<List<Contact>> get() = _contact

    init {
        _contact.value = planetRepository.retrieveAll(7)
    }

}