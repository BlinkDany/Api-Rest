package com.daniel.guiapractica4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daniel.guiapractica4.Io.RetrofitClient
import com.daniel.guiapractica4.Modelo.Persona
import com.daniel.guiapractica4.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitTraer = RetrofitClient.consumirApi.getTraer()

        retrofitTraer.enqueue(object : Callback<Persona>{
            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                binding.tvMostrar.text = response.body().toString()
            }

            override fun onFailure(call: Call<Persona>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Errror al consultar la api", Toast.LENGTH_SHORT).show()
            }

        })
    }
}