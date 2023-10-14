package tn.esprit.gamerapp_farah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import  androidx.fragment.app.FragmentManager
import tn.esprit.gamerapp_farah.databinding.ActivityMainBinding


class HomeActivity : AppCompatActivity() {

private  lateinit var fragmentManager: FragmentManager
private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private  fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }


}