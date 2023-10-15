package tn.esprit.gamerapp_farah


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import tn.esprit.gamerapp_farah.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

private  lateinit var fragmentManager: FragmentManager
private lateinit var binding: HomeActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
binding.bt1.setOnClickListener{
    goToFragment(News())
}


        binding.bt2.setOnClickListener{
            goToFragment(Store())
        }

    }


    private  fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }


}