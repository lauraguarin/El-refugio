package com.example.taller2_aplicacionesmoviles

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Recuperacion_contraseña_activity: AppCompatActivity() {

    private lateinit var editTextcorreo: EditText
    private lateinit var buttonEnviar: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion_contrasena)
        Log.d("Recuperacion_contraseña_activity", "onCreate: Recuperacion de contraseña Iniciada")
        sharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE)
        //inicializando las variable sgenerales
        editTextcorreo = findViewById(R.id.editTextemail)
        buttonEnviar = findViewById(R.id.boton_Recuperacion)
        //configurar el boton de envio
        buttonEnviar.setOnClickListener {
            if (validarCorreo()) {
                //verificacion del correo electronico
            }
        }
    }

    private fun validarCorreo(): Boolean {
        val correo = editTextcorreo.text.toString().trim()
        if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
             //mostrar mensaje de error
            return false
        }
        return true
    }
    private fun verificarCorreo(){
        val correo = editTextcorreo.text.toString().trim()
        val correoRegistrado = sharedPreferences.getString("correo","")

        if (correo == correoRegistrado){
            //Muestremensaje de "se ha enviado correo...."
            //log
            buttonEnviar.postDelayed({
             finish()
            },1500)
        }else{
            //mostrar mensaje de error
            //Log.d
        }
    }
    /*
* met viaulizar
* val correoRegistrado = sharedPreferences.getString("correo", "")
* textViewCorreo.text = sharedPreferences.getString("correo", "")
*/
}
//perfil del usuario
