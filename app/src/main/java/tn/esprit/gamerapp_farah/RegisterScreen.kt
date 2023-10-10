package tn.esprit.gamerapp_farah



import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText


class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeResId = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> R.style.Base_Theme_GamerApp_Farah_dark
            else -> R.style.Base_Theme_GamerApp_Farah
        }
        setTheme(themeResId)

        setContentView(R.layout.register_light)

        val primaryColor = ContextCompat.getColor(applicationContext,R.color.colorPrimary)
        val paragraphTextView = findViewById<TextView>(R.id.terms)
        val paragraphText = paragraphTextView.text.toString()
        val wordsToUnderline = listOf("Conditions", "privacy", "and", "Terms")
        val colorSpan = ForegroundColorSpan(primaryColor)
        val spannableStringBuilder = SpannableStringBuilder(paragraphText)



        val RegisterTextView  = findViewById<Button>(R.id.RegisterButton)




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

        for (word in wordsToUnderline) {
            val start = paragraphText.indexOf(word)
            val end = start + word.length

            if (start >= 0) {
                spannableStringBuilder.setSpan(
                    UnderlineSpan(),
                    start,
                    end,
                    0
                )

                // You can also apply other styles, like color or bold
                spannableStringBuilder.setSpan(
                    colorSpan,
                    start,
                    end,
                    0
                )
                spannableStringBuilder.setSpan(
                    ForegroundColorSpan(primaryColor),
                    start,
                    end,
                    0
                )
            }
        }

        paragraphTextView.text = spannableStringBuilder
        val paragraphTextView1 = findViewById<ImageView>(R.id.navigationIcon)
        paragraphTextView1.setOnClickListener {

            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)



        }
        RegisterTextView.setOnClickListener {
            val fullname = findViewById<TextInputEditText>(R.id.fullnameinput)
            val fullnametext = fullname.text.toString()
            val email = findViewById<TextInputEditText>(R.id.emailinput)
            val emailtext = email.text.toString()
            val Cpassword = findViewById<TextInputEditText>(R.id.confirmpasswordInput)
            val CpassText = Cpassword.text.toString()
            val password = findViewById<TextInputEditText>(R.id.passwordInput)
            val passText = password.text.toString()

            Log.d("fullname", fullnametext)
            Log.d("email", emailtext)
            Log.d("password", passText)
            Log.d("confirm pass", CpassText)
        }
    }


}