package ca.qc.cstj.s05localdatasource.presentation.adapters

import android.widget.AdapterView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.s05localdatasource.R
import ca.qc.cstj.s05localdatasource.databinding.ItemContactBinding
import ca.qc.cstj.s05localdatasource.domain.models.Contact

class AsyncContactRecyclerViewAdapter(private val onContactItemClick: (Contact) -> Unit )
    : RecyclerView.Adapter<AsyncContactRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemContactBinding.
        inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = differ.currentList[position]
        holder.bind(contact)

        holder.itemView.setOnClickListener{
            onContactItemClick(contact)
        }

    }

    // la liste de contact est dans differ
    override fun getItemCount(): Int = differ.currentList.size

     private val differCallBack = object : DiffUtil.ItemCallback<Contact>() {
         override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
             return oldItem.idContact == newItem.idContact
         }

         override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
             return oldItem == newItem
         }

     }

    val differ = AsyncListDiffer(this,differCallBack)


    inner class ViewHolder(private val binding : ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

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