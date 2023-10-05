package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding
import com.example.calculadora.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivityMain.root)

        bindingActivityMain.accederCalculadora.setOnClickListener() {
            if (bindingActivityMain.Usuario.text.toString() == "user" && bindingActivityMain.Contrasena.text.toString() == "password") {
                val bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)
                setContentView(bindingCalculadora.root)
            } else {
                bindingActivityMain.error.text = "Usuario o Contraseña no son correctos"
            }

        }

    }
}


