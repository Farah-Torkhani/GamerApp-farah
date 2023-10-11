package tn.esprit.gamerapp_farah

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText




class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val themeResId = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> R.style.Base_Theme_GamerApp_Farah_dark
            else -> R.style.Base_Theme_GamerApp_Farah
        }

        setTheme(themeResId) // Set the appropriate theme before calling setContentView

        setContentView(R.layout.login_light)
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
        val primaryColor = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        val paragraphTextView = findViewById<TextView>(R.id.buttonregister)
        val loginTextView  = findViewById<Button>(R.id.loginButton)

        val paragraphTextView1 = findViewById<TextView>(R.id.forgotPasswordTextButton)
        val paragraphText = paragraphTextView.text.toString()
        val wordsToUnderline = listOf("Register", "now")
        val colorSpan = ForegroundColorSpan(primaryColor)
        val spannableStringBuilder = SpannableStringBuilder(paragraphText)

        for (word in wordsToUnderline) {
            val start = paragraphText.indexOf(word)
            val end = start + word.length

            if (start >= 0) {
                spannableStringBuilder.setSpan(UnderlineSpan(), start, end, 0)
                spannableStringBuilder.setSpan(colorSpan, start, end, 0)
                spannableStringBuilder.setSpan(ForegroundColorSpan(primaryColor), start, end, 0)
            }
        }

        paragraphTextView.text = spannableStringBuilder
//dark mode switch




            paragraphTextView1.setOnClickListener() {

                val intent = Intent(this, ForgetPassword::class.java)
                startActivity(intent)

            }


        paragraphTextView.setOnClickListener {

            val intent = Intent(this@LoginScreen, RegisterScreen::class.java)
            startActivity(intent)

        }



        loginTextView.setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.emailinput)
            val emailtext = email.text.toString()
            val password = findViewById<TextInputEditText>(R.id.passwordinput)
            val passText = password.text.toString()
            Log.d("email", emailtext)
            Log.d("password", passText)
        }



    }

    }

