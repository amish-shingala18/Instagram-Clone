package com.example.instagram.activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagram.R
import com.example.instagram.adapter.ChatAdapter
import com.example.instagram.databinding.ActivityMessengerBinding
import com.google.android.material.tabs.TabLayoutMediator
class MessengerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessengerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMessengerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chatAdapter = ChatAdapter(this)
        binding.viewPagerChat.adapter = chatAdapter
        TabLayoutMediator(binding.txbChatCategories, binding.viewPagerChat) { tab, position ->
            when (position) {
                0 -> tab.text = "Primary"
                1 -> tab.text = "General"
                2 -> tab.text = "Public"
            }
        }.attach()
        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}