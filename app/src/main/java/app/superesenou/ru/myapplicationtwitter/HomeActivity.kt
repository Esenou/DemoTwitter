package app.superesenou.ru.myapplicationtwitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var username:String=intent.getStringExtra("username")
       var userId:Long=intent.getLongExtra("key",1)


        TV_username.text=userId.toString()
    }
}
