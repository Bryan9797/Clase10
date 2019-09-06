package com.jdev.clase10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener {

            var usuario = txtUsuario.text.toString()
            var contrasena = txtContrasena.text.toString()

            logearse(usuario, contrasena)
        }

        btnRegistrar.setOnClickListener {
            var usuario = txtUsuario.text.toString()
            var contrasena = txtContrasena.text.toString()

            registrarse(usuario, contrasena)
        }

    }

    fun logearse(usuario : String, contrasena : String ){

        mAuth?.signInWithEmailAndPassword(usuario, contrasena)?.addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = mAuth?.getCurrentUser()
                Toast.makeText(this, "Usuario y contraseña correctos",
                    Toast.LENGTH_SHORT).show()
                var intento = Intent(this, Inventario::class.java)
                startActivity(intento)

            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }


    fun registrarse(usuario : String, contrasena: String){

        mAuth?.createUserWithEmailAndPassword(usuario, contrasena)?.addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = mAuth?.getCurrentUser()
                Toast.makeText(this, "Se registro correctamente",
                    Toast.LENGTH_SHORT).show()
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }

        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth?.getCurrentUser()
    }

}
