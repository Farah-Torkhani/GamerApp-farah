package tn.esprit.gamerapp_farah


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import tn.esprit.gamerapp_farah.databinding.HomeActivityBinding




class HomeActivity : AppCompatActivity() {

private  lateinit var fragmentManager: FragmentManager
private lateinit var binding: HomeActivityBinding
private lateinit var binding1: HomeActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)
        val navView: BottomNavigationView = binding.bottomNavigation



        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_news -> {
                    goToFragment(News())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.item_store -> {
                    goToFragment(Store())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.item_profile -> {
                    goToFragment(profile())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }



    }



    private  fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true;
    }



}