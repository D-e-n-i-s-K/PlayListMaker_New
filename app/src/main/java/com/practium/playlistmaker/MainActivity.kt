package com.practium.playlistmaker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.buttonSearch)
        val mediaButton = findViewById<Button>(R.id.buttonMedia)
        val settingsButton = findViewById<Button>(R.id.buttonSettings)

        val mediabuttonOnClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val displayMedia = Intent(this@MainActivity, MediaActivity::class.java)
                startActivity(displayMedia)
            }
        }
        mediaButton.setOnClickListener(mediabuttonOnClickListener)

        settingsButton.setOnClickListener {
            val displayIntent = Intent(this, SettingsActivity::class.java)
            startActivity(displayIntent)
        }

        searchButton.setOnClickListener {
            val displaySearch = Intent(this, SearchActivity::class.java)
            startActivity(displaySearch)
        }

    }




    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Мы в методе onPause")
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}