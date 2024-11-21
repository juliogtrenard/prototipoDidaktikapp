package es.juliogtrenard.prototipoprincipal.actividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import es.juliogtrenard.prototipoprincipal.MainActivity
import es.juliogtrenard.prototipoprincipal.R

class AyudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        val botonVolver = findViewById<Button>(R.id.botonAyuda_volver)

        botonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}