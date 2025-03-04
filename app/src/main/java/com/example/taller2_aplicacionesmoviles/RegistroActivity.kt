package com.example.taller2_aplicacionesmoviles

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private lateinit var editTextNombres: EditText
private lateinit var editTextapellido: EditText
private lateinit var editTextCorreoelectronico: EditText
private lateinit var editTexttelefono: EditText
private lateinit var buttonRegistro: Button
private lateinit var sharedPreferences: SharedPreferences

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("RegistroActivity", "onCreate: Registro Activity Iniciado")
        // inicializar las variables
        sharedPreferences = getSharedPreferences("Userdata", MODE_PRIVATE)
        // INICIALIZAR LAS VARIABLES DE VISTAS
        editTextNombres = findViewById(R.id.editTextNombre)
        editTextapellido = findViewById(R.id.editTextapellido)
        editTextCorreoelectronico = findViewById(R.id.editTextCorreoelectronico)
        editTexttelefono = findViewById(R.id.editTexttelefono)
        buttonRegistro = findViewById(R.id.boton_ingresar_registro) // Corregido el findViewById

        // configuracion listener boton de registro
        buttonRegistro.setOnClickListener {
            if (validarCampos()) {
                //metodo de guardar los datos usuarios
                guardarDatosUsuario()
                //redireccionamiento
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun gotoiniciarsesion(view: View?) {
        startActivity(
            Intent(this,PefilActivity::class.java).apply {
                Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        );
        finish();
    };


    private fun validarCampos(): Boolean {
        val nombres = editTextNombres.text.toString().trim()


        if (nombres.isEmpty()) {
            Toast.makeText(this,"El campo Nombres es requerido",Toast.LENGTH_SHORT).show()
         //comprar que la contraseña sea correcta si si dejarla continuar,la de contraseña y confirmar contraseña
            return false

        }

        return true
    }

    private fun guardarDatosUsuario() {
        val editor = sharedPreferences.edit()
        editor.putString("nombre", editTextNombres.text.toString().trim())
        editor.putString("apellidos",editTextapellido.text.toString().trim())
        editor.putString("correo",editTextCorreoelectronico.text.toString().trim())
        editor.putString("telefono",editTexttelefono.text.toString().trim())
        editor.apply()
        //todos como string porque aun no podemos hacerlo en back
        Log.d("Registro Activity","guardardatosuauarios :datos del usuario guardados")
        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show()
        //mostartle pop ups temporales
    }


}