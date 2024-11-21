package es.juliogtrenard.prototipoprincipal.actividades

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import es.juliogtrenard.prototipoprincipal.MainActivity
import es.juliogtrenard.prototipoprincipal.R

class JugarActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var scaleDetector: ScaleGestureDetector

    private var scaleFactor = 1f
    private var lastScaleFactor = 1f
    private var minScale = 1f
    private var maxScale = 3f

    private var translateX = 0f
    private var translateY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar)

        /*val botonVolver = findViewById<Button>(R.id.botonJugar_volver)

        botonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }*/

        imageView = findViewById(R.id.imageView)

        // Crear el detector de gestos de escala
        scaleDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Detecta los gestos de escala
        scaleDetector.onTouchEvent(event)
        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            // Calcula el factor de escala basado en el gesto de pellizco
            scaleFactor = lastScaleFactor * detector.scaleFactor
            scaleFactor = scaleFactor.coerceIn(minScale, maxScale)

            // Aplicar el zoom
            imageView.scaleX = scaleFactor
            imageView.scaleY = scaleFactor

            // Calcular límites de desplazamiento después de zoom
            adjustTranslation()

            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector) {
            super.onScaleEnd(detector)
            lastScaleFactor = scaleFactor
        }
    }

    private fun adjustTranslation() {
        val imageWidth = imageView.drawable.intrinsicWidth * scaleFactor
        val imageHeight = imageView.drawable.intrinsicHeight * scaleFactor
        val screenWidth = imageView.width.toFloat()
        val screenHeight = imageView.height.toFloat()

        // Limitar la traslación horizontal (izquierda/derecha)
        translateX = translateX.coerceIn(
            screenWidth - imageWidth,  // Límite izquierdo
            0f  // Límite derecho
        )

        // Limitar la traslación vertical (arriba/abajo)
        translateY = translateY.coerceIn(
            screenHeight - imageHeight,  // Límite superior
            0f  // Límite inferior
        )

        // Aplicar los límites de la traducción a la imagen
        imageView.translationX = translateX
        imageView.translationY = translateY
    }
}