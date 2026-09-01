package com.neopulse.app

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CarritoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val contenedor = findViewById<LinearLayout>(R.id.contenedorProductosCarrito)
        val txtTotal = findViewById<TextView>(R.id.txtTotalCarrito)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)

        // Limpiamos la vista por si acaso
        contenedor.removeAllViews()

        // Verificamos si el carrito está vacío
        if (CarritoManager.itemsSeleccionados.isEmpty()) {
            val aviso = TextView(this).apply {
                text = "No hay productos en el carrito."
                setTextColor(Color.WHITE)
                textSize = 16f
            }
            contenedor.addView(aviso)
        } else {
            // Recorremos los productos seleccionados y armamos la vista dinámica con sus fotos
            for (i in CarritoManager.itemsSeleccionados.indices) {
                val itemLayout = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(0, 0, 0, 24)
                }

                val imgProducto = ImageView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        250
                    )
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImageResource(CarritoManager.imagenesSeleccionadas[i])
                }

                val txtNombre = TextView(this).apply {
                    text = CarritoManager.itemsSeleccionados[i]
                    setTextColor(Color.WHITE)
                    textSize = 14f
                    setPadding(0, 8, 0, 0)
                }

                itemLayout.addView(imgProducto)
                itemLayout.addView(txtNombre)
                contenedor.addView(itemLayout)
            }
        }

        // Calculamos y mostramos el total
        val total = CarritoManager.calcularTotal()
        txtTotal.text = "Total a pagar: $ $total"

        // Botón para finalizar la compra
        btnFinalizar.setOnClickListener {
            Toast.makeText(this, "¡Compra simulada con éxito! Pedido registrado.", Toast.LENGTH_LONG).show()
            CarritoManager.itemsSeleccionados.clear()
            CarritoManager.imagenesSeleccionadas.clear()
            finish() // Esto lo devuelve automáticamente a la pantalla principal
        }
    }
}