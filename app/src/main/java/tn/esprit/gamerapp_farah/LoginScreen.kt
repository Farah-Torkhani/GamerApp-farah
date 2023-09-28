package tn.esprit.gamerapp_farah

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_light)

        val primaryColor = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        val paragraphTextView = findViewById<TextView>(R.id.buttonregister)
        val paragraphText = paragraphTextView.text.toString()
        val wordsToUnderline = listOf("Register","now")
        val colorSpan = ForegroundColorSpan(primaryColor)
        val spannableStringBuilder = SpannableStringBuilder(paragraphText)
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
    }
}