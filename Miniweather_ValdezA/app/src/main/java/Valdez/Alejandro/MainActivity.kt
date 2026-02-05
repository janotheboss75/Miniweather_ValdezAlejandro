package Valdez.Alejandro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var index = 0
        val listaNombresClimas = listOf("cloudy","rainy","snowy","stormy","sunny","windy")
        val listaIconos = listOf(R.drawable.ic_cloudy, R.drawable.ic_rainy, R.drawable.ic_snowy, R.drawable.ic_stormy, R.drawable.ic_sunny, R.drawable.ic_windy)


        //Elementos inicializados
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvCity = findViewById<TextView>(R.id.tvCity)
        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvWeather = findViewById<TextView>(R.id.tvWeather)
        val btnUbicacion = findViewById<Button>(R.id.btnUbicacion)
        val btnClima = findViewById<Button>(R.id.btnClima)

        tvGreeting.setText("HI, ALEJANDRO!!!")
        tvCity.setText("China")
        ivWeather.setImageResource(R.drawable.ic_sunny)
        tvTemperature.setText("22°")
        tvWeather.setText("Sunny")

        btnUbicacion.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }

        btnClima.setOnClickListener {
            if(index + 1 < listaIconos.size){
                index += 1
            }
            else{
                index = 0
            }
            tvWeather.setText(listaNombresClimas[index])
            ivWeather.setImageResource(listaIconos[index])
        }


    }
}