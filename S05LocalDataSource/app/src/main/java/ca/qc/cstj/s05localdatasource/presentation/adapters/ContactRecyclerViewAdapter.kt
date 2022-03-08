package ca.qc.cstj.s05localdatasource.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ItemContactBinding
import ca.qc.cstj.s05localdatasource.domain.models.Contact

class ContactRecyclerViewAdapter(var contacts : List<Contact>)
    : RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size





    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemContactBinding.bind(view)

        fun bind(contact: Contact) {
            // Affichage d'un élément / d'un item de l'adapteur ( ici c'est un contact)
            binding.txvName.text = contact.fullName


            when(contact.isOnline){
                true -> {
                    binding.imvCloud.setImageResource(R.drawable.ic_baseline_cloud_24)
                }
                false -> {
                    binding.imvCloud.setImageResource(R.drawable.ic_baseline_cloud_off_24)
                }
            }

        }
    }

}