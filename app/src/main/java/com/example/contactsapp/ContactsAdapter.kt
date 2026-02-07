package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ItemContactBinding

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ContactViewholder>() {

    private var contactsList = mutableListOf<Contact>()
    var onDeleteClick: OnDeleteClick? = null
    var onDeleteClick2: ((Int) -> Unit)? = null
    fun setContactList(list: MutableList<Contact>) {
        contactsList = list
    }
    fun isEmpty()= contactsList.isEmpty()

    fun deleteContact(position: Int) {
        contactsList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addContact(contact: Contact){
        contactsList.add(contact)
        notifyItemInserted(contactsList.size-1)
    }

    class ContactViewholder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.nameTv.text = contact.name
            binding.ivPhoto.setImageResource(contact.image)
            binding.emailTv.text = contact.email
            binding.phoneTv.text = contact.phone

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewholder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewholder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactViewholder, position: Int) {
        val contact = contactsList[position]
        holder.bind(contact)

        holder.binding.deleteIcon.setOnClickListener { view ->
            //tell activity that a click happened on this position
            onDeleteClick2?.invoke(holder.adapterPosition)
        }

    }

    fun interface OnDeleteClick {
        fun onDelete(position: Int)
    }
}