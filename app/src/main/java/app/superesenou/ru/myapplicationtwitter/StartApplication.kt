package app.superesenou.ru.myapplicationtwitter



import android.app.Application
import app.superesenou.ru.myapplicationtwitter.data.ForumService
import app.superesenou.ru.myapplicationtwitter.data.Network

class StartApplication:Application() {


    private val BASE_URL="http://jsonplaceholder.typicode.com"
    private val BASE_URL_W="http://api.apixu.com"
    private val BASE_URL_WEBRAND="http://webrand.kg"
    companion object {
        @Volatile
        lateinit var service: ForumService
        //lateinit var servicew:ForumService
       // lateinit var servicewebrand: ForumService

    }

    override fun onCreate() {
        super.onCreate()
        service= Network.initService(BASE_URL)
        //servicew=Network.initService(BASE_URL_W)
        //servicewebrand=Network.initService(BASE_URL_WEBRAND)
    }

}