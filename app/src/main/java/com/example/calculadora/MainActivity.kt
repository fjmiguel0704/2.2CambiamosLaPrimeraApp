package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding
import com.example.calculadora.databinding.CalculadoraBinding

class MainActivity : AppCompatActivity() {
    /*
    binding para poder acceder a los elementos de la vista activity_main
     */
    lateinit var bindingActivityMain: ActivityMainBinding
    /*
    binding para acceder a los elementos de la vista Calculadora
     */
    lateinit var bindingCalculadora: CalculadoraBinding
    /*
    variable para guardar el primer factor en formato número decimal
     */
    var num1: Double = 0.0
    /*
    variable para guardar el segundo factor en formato número decimal
     */
    var num2: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaramos el binding para el Activity Main
        bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)
        //Declaramos el binding para la Calculadora
        bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)

        //Abrimos la vista activity_main como primaria
        setContentView(bindingActivityMain.root)

        /**
         * Método que al hacer clic en el botón de iniciar sesión, comprueba si el nombre de usuario
         * y contraseña escritos son correctos. En caso de que si, accede a la vista calculadora, y en caso de que no, muestra un mensaje de error
         */
        bindingActivityMain.accederCalculadora.setOnClickListener() {
            if (bindingActivityMain.Usuario.text.toString() == "user" && bindingActivityMain.Contrasena.text.toString() == "password") {
                setContentView(bindingCalculadora.root)
            } else {
                bindingActivityMain.error.text = "Usuario o Contraseña no son correctos"
            }

        }

        /**
         * Método que al hacer clic sobre el botón suma, accede a los 2 factores introducidos, coge sus valores
         * y los convierte a String almacenándolos en una variable. Comprueba si los campos están vacíos
         * y muestra un error, en caso de no estralos, convierte los valores a tipo númerico decimal, los suma y convierte
         * el resultado la suma en tipo String para mostrarla
         */
        bindingCalculadora.calculaSuma.setOnClickListener {
            val num1Text =  bindingCalculadora.PrimerFactor.text.toString()
            val num2Text = bindingCalculadora.SegundoFactor.text.toString()

            if (num1Text.isEmpty() && num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Los campos no pueden estar vacíos"
                bindingCalculadora.Resultado.text = "0.0"
            }else if (num1Text.isEmpty() || num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Alguno de los campos está vacío"
                bindingCalculadora.Resultado.text = "0.0"
            } else {
                num1 = num1Text.toDouble()
                num2 = num2Text.toDouble()
                var result = num1 + num2
                var resultString = result.toString()
                bindingCalculadora.textoCampoVacio.text = ""
                bindingCalculadora.Resultado.text = resultString
            }
        }

        /**
         * Método que al hacer clic sobre el botón resta, accede a los 2 factores introducidos, coge sus valores
         * y los convierte a String almacenándolos en una variable. Comprueba si los campos están vacíos
         * y muestra un error, en caso de no estralos, convierte los valores a tipo númerico decimal, los resta y convierte el
         * resultado de la resta en tipo String para mostrarla
         */
        bindingCalculadora.calculaResta.setOnClickListener {
            val num1Text =  bindingCalculadora.PrimerFactor.text.toString()
            val num2Text = bindingCalculadora.SegundoFactor.text.toString()

            if (num1Text.isEmpty() && num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Los campos no pueden estar vacíos"
                bindingCalculadora.Resultado.text = "0.0"
            }else if (num1Text.isEmpty() || num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Alguno de los campos está vacío"
                bindingCalculadora.Resultado.text = "0.0"
            } else {
                num1 = num1Text.toDouble()
                num2 = num2Text.toDouble()
                var result = num1 - num2
                var resultString = result.toString()
                bindingCalculadora.textoCampoVacio.text = ""
                bindingCalculadora.Resultado.text = resultString
            }
        }

        /**
         * Método que al hacer clic sobre el botón multiplicar, accede a los 2 factores introducidos, coge sus valores
         * y los convierte a String almacenándolos en una variable. Comprueba si los campos están vacíos
         * y muestra un error, en caso de no estralos, convierte los valores a tipo númerico decimal, los multiplica y convierte el resultado
         * de la multiplicación en tipo String para mostrarla
         */
        bindingCalculadora.calculaMultiplicacion.setOnClickListener {
            val num1Text =  bindingCalculadora.PrimerFactor.text.toString()
            val num2Text = bindingCalculadora.SegundoFactor.text.toString()

            if (num1Text.isEmpty() && num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Los campos no pueden estar vacíos"
                bindingCalculadora.Resultado.text = "0.0"
            }else if (num1Text.isEmpty() || num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Alguno de los campos está vacío"
                bindingCalculadora.Resultado.text = "0.0"
            } else {
                num1 = num1Text.toDouble()
                num2 = num2Text.toDouble()
                var result = num1 * num2
                var resultString = result.toString()
                bindingCalculadora.textoCampoVacio.text = ""
                bindingCalculadora.Resultado.text = resultString
            }
        }

        /**
         * Método que al hacer clic sobre el botón division, accede a los 2 factores introducidos, coge sus valores
         * y los convierte a String almacenándolos en una variable. Comprueba si los campos están vacíos
         * o el segundo campo es 0 y muestra o salta un error, en caso de no estralos, convierte los valores a tipo númerico
         * decimal, los divide y convierte el resultado de la division en tipo String para mostrarla
         */
        bindingCalculadora.calculaDivision.setOnClickListener {
            val num1Text =  bindingCalculadora.PrimerFactor.text.toString()
            val num2Text = bindingCalculadora.SegundoFactor.text.toString()

            if (num1Text.isEmpty() && num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Los campos no pueden estar vacíos"
                bindingCalculadora.Resultado.text = "0.0"
            }else if (num1Text.isEmpty() || num2Text.isEmpty()){
                bindingCalculadora.textoCampoVacio.text = "Alguno de los campos está vacío"
                bindingCalculadora.Resultado.text = "0.0"
            } else if (num2Text == "0") {
                bindingCalculadora.Resultado.text = "0.0"
                val toast =
                    Toast.makeText(applicationContext, "No es posible realizar la operación", Toast.LENGTH_SHORT).show()
            } else {
                num1 = num1Text.toDouble()
                num2 = num2Text.toDouble()
                var result = num1 / num2
                var resultString = result.toString()
                bindingCalculadora.textoCampoVacio.text = ""
                bindingCalculadora.Resultado.text = resultString
            }
        }

        /**
         * Método que al hacer clic sobre el botón para volver hacía atrás, te vuelva a la página de login
         */
        bindingCalculadora.vueltaInicioSesion.setOnClickListener {
            setContentView(bindingActivityMain.root)
        }

    }

}


