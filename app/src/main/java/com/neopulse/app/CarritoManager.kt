package com.neopulse.app

object CarritoManager {
    val itemsSeleccionados = mutableListOf<String>()
    val imagenesSeleccionadas = mutableListOf<Int>()

    fun agregarProducto(nombre: String, imagenResId: Int) {
        itemsSeleccionados.add(nombre)
        imagenesSeleccionadas.add(imagenResId)
    }

    fun calcularTotal(): Int {
        var total = 0
        for (item in itemsSeleccionados) {
            when {
                item.contains("K-MK200") -> total += 100000
                item.contains("M-ECG500") -> total += 72000
                item.contains("G-HP100") -> total += 65000
            }
        }
        return total
    }
}