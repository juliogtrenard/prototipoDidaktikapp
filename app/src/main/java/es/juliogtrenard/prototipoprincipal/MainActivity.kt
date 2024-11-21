package es.juliogtrenard.prototipoprincipal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import es.juliogtrenard.prototipoprincipal.actividades.AyudaActivity
import es.juliogtrenard.prototipoprincipal.actividades.JugarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardViewJugar: CardView = findViewById(R.id.card_jugar)
        cardViewJugar.setOnClickListener {
            val intent = Intent(this, JugarActivity::class.java)
            startActivity(intent)
        }

        val cardViewAyuda: CardView = findViewById(R.id.card_ayuda)
        cardViewAyuda.setOnClickListener {
            val intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent)
        }
    }
}