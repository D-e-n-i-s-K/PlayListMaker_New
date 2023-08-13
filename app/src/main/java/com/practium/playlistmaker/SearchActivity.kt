package com.practium.playlistmaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.text.set


class SearchActivity : AppCompatActivity() {

    companion object {
        const val SEARCH_TEXT = "SEARCH_TEXT"
    }


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


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
         outState.putString(SEARCH_TEXT, searchEditText.text.toString())

       // тут ВОПРОСК к РЕВЬЮЕРУ... при повороте экрана на эмуляторе значение текстового поля не срасывается, ПОЧЕМУ???

      //  Toast.makeText(this, "отработал onSaveInstanceState записали ${searchEditText.text.toString()} " +
        //         "по ключу $SEARCH_TEXT", Toast.LENGTH_SHORT).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        searchEditText.setText(savedInstanceState.getString(SEARCH_TEXT,""))

       // Toast.makeText(this, "отработал onRestoreInstanceState", Toast.LENGTH_SHORT).show()
    }

    }


