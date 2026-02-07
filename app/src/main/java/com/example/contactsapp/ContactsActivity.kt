package com.example.contactsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.contactsapp.ValidationUtils.validateEmail
import com.example.contactsapp.ValidationUtils.validateName
import com.example.contactsapp.ValidationUtils.validatePhone
import com.example.contactsapp.databinding.ActivityContactsBinding
import com.example.contactsapp.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactsBinding
    private val adapter= ContactsAdapter()
    private val contactsList = mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactsBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_contacts)
        setContentView(binding.root)  // this is the new when using binding
        updateUIState()
        initContactsRV()
        onAddContactClick()
    }



    private fun onAddContactClick() {
        binding.fabAddContact.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetBinding = BottomSheetBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)
            bottomSheetDialog.show()

            bottomSheetBinding.addContactBtn.setOnClickListener{
                val name = bottomSheetBinding.nameEdt.text?.trim().toString()
                val phone = bottomSheetBinding.phoneEdt.text?.trim().toString()
                val email = bottomSheetBinding.emailEdt.text?.trim().toString()

                if (!validateTextField(bottomSheetBinding)){
                    return@setOnClickListener
                }
                //add contact
                val contact = Contact(name= name, phone=phone, email=email)
                adapter.addContact(contact)
                updateUIState()
                bottomSheetDialog.dismiss()

            }

        }
    }

    private fun validateTextField(bottomSheetBinding: BottomSheetBinding): Boolean {
        val name = bottomSheetBinding.nameEdt.text?.trim().toString()
        val phone = bottomSheetBinding.phoneEdt.text?.trim().toString()
        val email = bottomSheetBinding.emailEdt.text?.trim().toString()

        val nameError = validateName(name)
        val phoneError = validatePhone(phone)
        val emailError = validateEmail(email)

        bottomSheetBinding.nameTil.error = nameError
        bottomSheetBinding.phoneTil.error = phoneError
        bottomSheetBinding.emailTil.error = emailError

        return nameError==null && phoneError==null && emailError==null


    }

    private fun initContactsRV() {
        binding.rvContacts.adapter= adapter
        adapter.setContactList(contactsList)

        adapter.onDeleteClick2= {position->
            adapter.deleteContact(position)
            updateUIState()
        }
    }

    private fun updateUIState() {
        if (adapter.isEmpty()){
            updateUIforEmptyState()
        }else{
            updateUIForSuccessState()
        }
    }

    private fun updateUIForSuccessState() {
        binding.rvContacts.isVisible=true
        binding.emptyView.isVisible=false
    }

    private fun updateUIforEmptyState() {
        binding.rvContacts.isVisible=false
        binding.emptyView.isVisible=true
    }
}