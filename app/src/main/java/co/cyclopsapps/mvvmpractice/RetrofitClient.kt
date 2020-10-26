package co.cyclopsapps.mvvmpractice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Carlos Daniel Agudelo on 11/10/2020.
 */
object RetrofitClient {
    private var retrofit: Retrofit? = null

    private val logger: OkHttpClient
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) httpClient.interceptors().add(logging)
            return httpClient.build()
        }

    val getClient: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://restaurantapp.bias.mx/web/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(logger)
                    .build()
            }
            return retrofit
        }
}