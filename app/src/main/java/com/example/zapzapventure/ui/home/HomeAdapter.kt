package com.example.zapzapventure.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.R
import com.example.zapzapventure.model.Contact

class HomeAdapter(val onContactSelected : (contact: Contact) -> Unit): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var contact: ArrayList<Contact> = ArrayList<Contact>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val ContactName: TextView = itemView.findViewById(R.id.contact_name)
        private val ContactDetail: TextView = itemView.findViewById(R.id.contact_details)
         val send: ImageView = itemView.findViewById(R.id.imgsend)

        fun setUser(Contact: Contact){
            ContactName.text = Contact.name
            ContactDetail.text = Contact.email
<<<<<<< HEAD

=======
            //TODO: set image
>>>>>>> b0d75ff2afef626ee1a5c46e914f43f212579e38
        }
    }

    fun setContactsList(Contacts: ArrayList<Contact>){
        this.contact = Contacts
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_contato_list, parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.setUser(contact[position])
        holder.send.setOnClickListener {
            onContactSelected(contact[position])
        }
    }

    override fun getItemCount(): Int {
        return contact.size
    }
}