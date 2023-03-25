package com.example.retrofit_api_calling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_api_calling.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var countryList = java.util.ArrayList<CountryModel2>()

    companion object {

        var countryList = ArrayList<CountryModel2>()
    }

    lateinit var adapter: CountryAdapter
    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)

        apiInterface.getallcountry().enqueue(object : Callback<List<CountryModel2>?> {
            override fun onResponse(
                call: Call<List<CountryModel2>?>,
                response: Response<List<CountryModel2>?>
            ) {

                if (response.isSuccessful) {

                    var CountryClick = object : CountryClick {
                        override fun onTap(i: Int) {

                            startActivity(
                                Intent(this@MainActivity, Detail_Activity::class.java)
                                    .putExtra("pos", i)
                            )
                        }
                    }

                    countryList = response.body() as ArrayList<CountryModel2>
                    adapter = CountryAdapter(countryList,CountryClick)
                    bindings.rcvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
                    bindings.rcvUsers.adapter = adapter
                    Log.e(TAG, "onResponse True")
                }
            }

            override fun onFailure(call: Call<List<CountryModel2>?>, t: Throwable) {

                Log.e(TAG, "onFailure False")
            }
        })
    }
}


