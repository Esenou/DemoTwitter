package app.superesenou.ru.myapplicationtwitter

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.superesenou.ru.myapplicationtwitter.ui.autorization.HomeActivity
import com.twitter.sdk.android.core.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Twitter.initialize(this);
        setContentView(R.layout.activity_main)

        login_button.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>?) {
                val session = TwitterCore.getInstance().sessionManager.activeSession
                val authToken = session.authToken
                val token = authToken.token
                val secret = authToken.secret
                login(session)
            }
            override fun failure(exception: TwitterException?) {

                Toast.makeText(this@MainActivity,"Authentication Failed!", Toast.LENGTH_LONG).show()

            }


        }
    }

    fun login(session:TwitterSession){
        var username:String=session.userName
        var id_user: Long? =session.userId
        val intent= Intent(this, HomeActivity::class.java)
        val bundle:Bundle
        intent.putExtra("key",id_user)
        intent.putExtra("username",username)

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result to the login button.
        login_button.onActivityResult(requestCode, resultCode, data)
    }
}
