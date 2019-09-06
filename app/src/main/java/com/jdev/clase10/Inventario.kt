package com.jdev.clase10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inventario.*
import com.google.firebase.database.FirebaseDatabase

class Inventario : AppCompatActivity() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("Inventario")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventario)


        btnAgregar.setOnClickListener {

            var nombre = txtNombre.text.toString()
            var descripcion = txtDescripcion.text.toString()
            var precio = txtPrecio.text.toString().toFloat()
            var stock = txtStock.text.toString().toInt()

            var producto = Producto(nombre, descripcion, precio, stock)

            myRef.child(myRef.push().key.toString()).setValue(producto)

        }


    }
}
