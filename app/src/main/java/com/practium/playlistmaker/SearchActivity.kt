package com.practium.playlistmaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.text.set


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val toMainMenuButton = findViewById<TextView>(R.id.buttonBack)
        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val cancelButton = findViewById<ImageButton>(R.id.cancelButton)

        cancelButton.visibility = View.GONE

        cancelButton.setOnClickListener(){
            searchEditText.text.clear()
        }

        val searchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                cancelButton.visibility = setCancelButtonVisible(s)
            }
        }

        searchEditText.addTextChangedListener(searchTextWatcher)

        toMainMenuButton.setOnClickListener {
            finish()
        }

        }

        fun setCancelButtonVisible(s : CharSequence?): Int {
            return if (s.isNullOrEmpty()) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }



    }


