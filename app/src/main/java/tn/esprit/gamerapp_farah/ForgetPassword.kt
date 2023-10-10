package tn.esprit.gamerapp_farah

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class ForgetPassword : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val themeResId = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> R.style.Base_Theme_GamerApp_Farah_dark
            else -> R.style.Base_Theme_GamerApp_Farah
        }

        setTheme(themeResId)

        setContentView(R.layout.forgot_password)

        val switchDarkMode = findViewById<Switch>(R.id.switchDarkMode)

        var isDarkModeEnabled = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        switchDarkMode.isChecked = isDarkModeEnabled

        switchDarkMode.setOnClickListener { view ->
            // Check if the state is changing
            val newState = switchDarkMode.isChecked
            if (newState != isDarkModeEnabled) {
                isDarkModeEnabled = newState
                if (isDarkModeEnabled) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    Log.d("", "This is a dark mode")
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Log.d("", "This is a light mode")
                }

            }
            recreate()
        }

        val paragraphTextView = findViewById<ImageView>(R.id.navigationIcon)
        paragraphTextView.setOnClickListener {

            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)

        }
        val sms = findViewById<Button>(R.id.Sendsms)
        sms.setOnClickListener {

            val intent = Intent(this, otpScreen::class.java)
            startActivity(intent)

        }


    }
}