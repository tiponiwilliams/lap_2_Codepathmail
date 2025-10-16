package com.example.lap2_codepathmail

import Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 1. The constructor `(private val emails: List<Email>)` goes on the adapter class.
class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    // 2. The ViewHolder should be a separate inner class.
    // It holds the views for each item.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // These are the views from your email_item.xml layout
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // The init block finds the views in the layout.
        init {
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
        }
    }

    // The adapter needs to implement three methods:

    // Inflates the item layout and creates the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populates data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on your views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return emails.size // This should be the only line here.
    }
}
