package es.juliogtrenard.prototipoprincipal.actividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import es.juliogtrenard.prototipoprincipal.MainActivity
import es.juliogtrenard.prototipoprincipal.R

class JugarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar)

        val botonVolver = findViewById<Button>(R.id.botonJugar_volver)

        botonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}