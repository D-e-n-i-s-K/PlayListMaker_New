package com.practium.playlistmaker

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backToMainActivityButton = findViewById<Button>(R.id.backToMainActivityButton)

        val shareAppButton = findViewById<Button>(R.id.shareAppButton)
        val supportMailButtonButton = findViewById<Button>(R.id.supportMailButton)
        val usersAgreementButton = findViewById<Button>(R.id.usersAgreementButton)

        backToMainActivityButton.setOnClickListener(){
            finish()
        }

        shareAppButton.setOnClickListener(){

            val shareAppDisplay = Intent(Intent.ACTION_SEND)
            shareAppDisplay.data = Uri.parse("https:")
            shareAppDisplay.putExtra(Intent.EXTRA_TEXT, "https://practicum.yandex.ru/android-developer/?from=catalog")
            shareAppDisplay.type = "text/plain"
            startActivity(shareAppDisplay)

        }

        supportMailButtonButton.setOnClickListener(){

            val mailAddress = arrayOf("irina_tillypad@mail.ru","kondratyev_dv@mail.ru")
            val nailSubject = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val mailText = "Спасибо разработчикам и разработчицам за крутое приложение!"
            val mailToSupportDisplay = Intent(Intent.ACTION_SENDTO)
            mailToSupportDisplay.data = Uri.parse("mailto:")
            mailToSupportDisplay.putExtra(Intent.EXTRA_EMAIL, mailAddress)
            mailToSupportDisplay.putExtra(Intent.EXTRA_TEXT, mailText)
            mailToSupportDisplay.putExtra(Intent.EXTRA_SUBJECT, nailSubject)

            try {
                startActivity(mailToSupportDisplay)
            } catch (e: ActivityNotFoundException) {

                val text = "Отработало исключение на кнопке поддержка startActivity(sendIntent)!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()

            }
        }
        usersAgreementButton.setOnClickListener(){

            val usersAgreementDisplay = Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/legal/practicum_offer/"))
            startActivity(usersAgreementDisplay)
        }
    }
}