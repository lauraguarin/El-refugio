package com.example.taller2_aplicacionesmoviles

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        //inicializando las variables generales
        editTextcorreo = findViewById(R.id.editTextemail)
        buttonEnviar = findViewById(R.id.boton_Recuperacion)
        //configurar el boton de envio
        buttonEnviar.setOnClickListener {
            if (validarCorreo()) {
                //verificacion del correo electronico
                verificarCorreo()
            }
        }
    }


    private fun validarCorreo(): Boolean {
        val correo = editTextcorreo.text.toString().trim()
        if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this,"no funciona el boton", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    private fun verificarCorreo(){
        val correo = editTextcorreo.text.toString().trim()
        val correoRegistrado = sharedPreferences.getString("correo","")

        if (correo == correoRegistrado){
            Log.d("Recuperar Contraseña", "verificarCorreo: Verificar el correo del usuario que este correctamente")
            Toast.makeText(this, "Se le ha enviado un correo con su nueva contraseña de recuperación", Toast.LENGTH_SHORT).show();


            //Muestremensaje de "se ha enviado correo...."
            //log
            buttonEnviar.postDelayed({
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
             finish()
            },1500)
        }else{
            Toast.makeText(this,"el correo no se encuentra registrado", Toast.LENGTH_SHORT).show()
            //mostrar mensaje de error
            //Log.d
            Log.d("Recuperar Contraseña", "verificarCorreo: Error correo: $correo,  correoRegistrado: $correoRegistrado")

        }
    }
    /*
* met viaulizar
* val correoRegistrado = sharedPreferences.getString("correo", "")
* textViewCorreo.text = sharedPreferences.getString("correo", "")
*/
}
//perfil del usuario
