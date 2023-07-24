package com.practium.playlistmaker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SearchActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        var toMainMenuButton = findViewById<TextView>(R.id.back)
        toMainMenuButton.setOnClickListener(){
            val displayMainActivity = Intent(this, MainActivity::class.java)
            startActivity(displayMainActivity)
        }
    }
}