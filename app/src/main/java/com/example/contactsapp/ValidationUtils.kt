package com.example.contactsapp

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Patterns
import org.intellij.lang.annotations.Pattern

object ValidationUtils {
    fun validateName(name: String):String?{
        if (name.isBlank()){
            return "Required Field"
        }
        if (!name.all { it.isLetter() }){
            return "name should contain only letters"
        }
        return null
    }
    fun validateEmail(email: String):String?{
        if (email.isBlank()){
            return "Required Field"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid Email format"
        }
        return null
    }
    fun validatePhone(phone: String):String?{
        if (phone.isBlank()){
            return "Required Field"
        }
        if (!phone.matches("^[0-9]{7,15}+$".toRegex())){
            return "Invalid phone format"
        }
        return null
    }

}