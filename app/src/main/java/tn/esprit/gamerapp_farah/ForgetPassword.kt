package tn.esprit.gamerapp_farah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class ForgetPassword : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

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