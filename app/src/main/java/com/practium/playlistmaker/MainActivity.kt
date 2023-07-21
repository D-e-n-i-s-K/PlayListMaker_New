package com.practium.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.search)
        val mediaButton = findViewById<Button>(R.id.media)
        val settingsButton = findViewById<Button>(R.id.settings)

        val mediabuttonOnClickListener : View.OnClickListener = object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Солнышко, привет!!!", Toast.LENGTH_SHORT).show()
            }
        }
        mediaButton.setOnClickListener(mediabuttonOnClickListener)

        settingsButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажата кнопка Настройки (метод )",Toast.LENGTH_SHORT).show()
        }









            val searchOnClickListener: View.OnClickListener =
                object : View.OnClickListener{
                    override fun onClick(v: View?) {
                       Toast.makeText(this@MainActivity,
                       "Привет, Валентин Георгиевич", Toast.LENGTH_LONG).show()
                    }
                }
            searchButton.setOnClickListener(searchOnClickListener)


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