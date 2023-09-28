package tn.esprit.gamerapp_farah

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_light)
        val intent = Intent(this, LoginScreen::class.java)
      //  val intent = Intent(this, LoginScreen::class.java)
        // Create an Intent to start the registerScreen activity
       //q val intent = Intent(this, RegisterScreen::class.java)

        // Start the activity
        startActivity(intent)

    }

}
