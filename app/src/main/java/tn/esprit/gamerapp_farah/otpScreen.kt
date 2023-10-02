package tn.esprit.gamerapp_farah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class otpScreen : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_validation)

        val primaryColor = ContextCompat.getColor(applicationContext,R.color.colorPrimary)
        val paragraphTextView = findViewById<TextView>(R.id.buttonresendcode)
        val paragraphText = paragraphTextView.text.toString()
        val wordsToUnderline = listOf("Resend", "code")
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

        val paragraphTextView1 = findViewById<ImageView>(R.id.navigationIcon)
        paragraphTextView1.setOnClickListener {

            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)

        }
    }

}
