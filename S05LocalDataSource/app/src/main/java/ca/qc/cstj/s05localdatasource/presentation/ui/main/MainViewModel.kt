package ca.qc.cstj.s05localdatasource.presentation.ui.main

import android.app.Application
import androidx.lifecycle.*
import ca.qc.cstj.s05localdatasource.data.AppDatabase
import ca.qc.cstj.s05localdatasource.data.repositories.ContactRepository
import ca.qc.cstj.s05localdatasource.domain.models.Contact
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application) {

    private val contactRepository = AppDatabase.getDatabase(application).ContactRepository()

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts : LiveData<List<Contact>> get() = _contacts

    init {
        // collect == await
        // await , prend le resultat , met le dans value
        viewModelScope.launch {
            contactRepository.retrieveAll().collect {
                _contacts.value = it
            }
        }

    }

    fun createContact(firstName: String, lastName: String, isOnline: Boolean) {
        val contact = Contact(firstName,lastName,isOnline)
        viewModelScope.launch {
            contactRepository.create(contact)
        }

    }

    fun delete(contact: Contact) {
        viewModelScope.launch {
            contactRepository.delete(contact)
        }
    }

    fun update(contact: Contact){
        viewModelScope.launch {
            contactRepository.update(contact)
        }
    }


}