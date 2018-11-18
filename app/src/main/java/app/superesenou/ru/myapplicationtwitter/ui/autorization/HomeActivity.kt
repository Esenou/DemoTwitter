package app.superesenou.ru.myapplicationtwitter.ui.autorization

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import app.superesenou.ru.myapplicationtwitter.R
import app.superesenou.ru.myapplicationtwitter.ui.addtwitter.AddTwitterFragment
import app.superesenou.ru.myapplicationtwitter.ui.lenta.LentaFragment
import app.superesenou.ru.myapplicationtwitter.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_home.*




class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        replaceFragment(LentaFragment())
        var username:String=intent.getStringExtra("username")
        var userId:Long=intent.getLongExtra("key",1)

        TV_username.text=userId.toString()
    }

    private val mOnNavigationItemSelectedListener= BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener when(item.itemId) {
            R.id.lentaId-> {
                println("right pressed")
                replaceFragment(LentaFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.addTwitterId->{
                println("middle pressed")
                replaceFragment(AddTwitterFragment())
                return@OnNavigationItemSelectedListener  true
            }
            R.id.searchId->{
                println("left pressed")
                replaceFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            else->false

        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}
