package com.neopulse.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTeclado = findViewById<Button>(R.id.btnTeclado)
        val btnMouse = findViewById<Button>(R.id.btnMouse)
        val btnAudifonos = findViewById<Button>(R.id.btnAudifonos)
        val btnVerCarrito = findViewById<Button>(R.id.btnVerCarrito)

        btnTeclado.setOnClickListener {
            CarritoManager.agregarProducto("Teclado K-MK200 - $ 100.000", R.drawable.teclado)
            Toast.makeText(this, "¡Teclado añadido al carrito!", Toast.LENGTH_SHORT).show()
        }

        btnMouse.setOnClickListener {
            CarritoManager.agregarProducto("Mouse M-ECG500 - $ 72.000", R.drawable.mouse)
            Toast.makeText(this, "¡Mouse añadido al carrito!", Toast.LENGTH_SHORT).show()
        }

        btnAudifonos.setOnClickListener {
            CarritoManager.agregarProducto("Audífonos G-HP100 - $ 65.000", R.drawable.audifonos)
            Toast.makeText(this, "¡Audífonos añadidos al carrito!", Toast.LENGTH_SHORT).show()
        }

        btnVerCarrito.setOnClickListener {
            startActivity(Intent(this, CarritoActivity::class.java))
        }
    }
}