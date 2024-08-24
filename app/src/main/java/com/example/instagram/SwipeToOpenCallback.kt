package com.example.instagram

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.activity.MessengerActivity

class SwipeToOpenChatCallback(val activity: FragmentActivity) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {

        Toast.makeText(activity, "Swipe", Toast.LENGTH_SHORT).show()
        return true
    }
    // ... onMove method (not used)

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // Trigger the animation to open the chat page
        val intent = Intent(activity, MessengerActivity::class.java)
        activity.startActivity(intent)
    }
}