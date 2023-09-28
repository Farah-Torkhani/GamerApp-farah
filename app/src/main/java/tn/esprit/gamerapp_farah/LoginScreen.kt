package tn.esprit.gamerapp_farah

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val themeResId = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> R.style.Base_Theme_GamerApp_Farah
            else -> R.style.Theme_GamerApp_Farah
        }

        // Set the app theme based on the determined theme resource ID
        setTheme(themeResId)

        setContentView(R.layout.login_light)

        val primaryColor = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        val paragraphTextView = findViewById<TextView>(R.id.buttonregister)
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

        val switchDarkMode = findViewById<Switch>(R.id.switchDarkMode)
        switchDarkMode.isChecked = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> true
            else -> false
        }

        val switch = findViewById<Switch>(R.id.switchDarkMode)
        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch to dark theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch to light theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            recreate() // Recreate the activity to apply the new theme
        }
    }
}
