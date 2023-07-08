package com.example.pasarelaf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Descripcion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etDate2 = findViewById<EditText>(R.id.etDate2)
        etDate.setOnClickListener { showDatePickerDialog() }
        etDate2.setOnClickListener { showDatePickerDialog2() }

        //Volver
        val btnV: Button = findViewById(R.id.btnClaseReserva1)
        btnV.setOnClickListener{
            val intent: Intent = Intent(this, Habitacion::class.java)
            startActivity(intent)
        }
        //Llamar a la Pasarela
        val btnR: Button = findViewById(R.id.btnVolver10)
        btnR.setOnClickListener{
            val intent: Intent = Intent(this, Habitaciones1::class.java)
            startActivity(intent)
        }

        val NH = 1
        val txtV1 =findViewById<TextView>(R.id.txtTipo)
        val txtV2 =findViewById<TextView>(R.id.txtCama1)
        val txtV3 =findViewById<TextView>(R.id.txtCama2)
        val txtV4 =findViewById<TextView>(R.id.txtTam)
        val txtV5 =findViewById<TextView>(R.id.txtPrecio)

        val queue = Volley.newRequestQueue(this)
        val urlReserva = "http://1192.168.1.36:8080/api/reservar/v1/reserva"
        val urlHotel = "http://192.168.1.36:8080/api/reservar/v1/hotel"
        val urlHabitacion = "http://192.168.1.36:8080/api/reservar/v1/habitacion"
       // val urlReserva = "http://20.121.72.196:3000/api/reservar/v1/reserva"
       // val urlHotel = "http://20.121.72.196:3000/api/reservar/v1/hotel"
        //val urlHabitacion = "http://20.121.72.196:3000/api/reservar/v1/habitacion"

        val stringRequest = StringRequest(Request.Method.GET,urlHabitacion, Response.Listener { response ->
            val jsonObject = JSONObject(response)

            //Habitacion
            val Habitaciones = jsonObject.getJSONArray("datos")
            for(i in 0 until Habitaciones.length()){
                val HabitacionBuscada = Habitaciones.getJSONObject(i)
                if(HabitacionBuscada.getInt("habitacionId") == NH){
                    val tipo = HabitacionBuscada.getString("tipo")
                    val cama1 = HabitacionBuscada.getString("camasPersonales")
                    val cama2 = HabitacionBuscada.getString("camasDoble")
                    val tam = HabitacionBuscada.getString("tamaño")
                    val precio = HabitacionBuscada.getString("precio")
                    txtV1.text = tipo.toString()
                    txtV2.text = cama1.toString()
                    txtV3.text = cama2.toString()
                    txtV4.text = tam.toString()
                    txtV5.text = "S/."+precio.toString()
                }
            }
        }, Response.ErrorListener { error ->
            Toast.makeText(applicationContext, "Error de conexión", Toast.LENGTH_SHORT).show();
        })
        queue.add(stringRequest)
    }

    //Fecha de Entrada
    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val etDate = findViewById<EditText>(R.id.etDate)
        val month2 = month+1
        etDate.setText("Fecha de Entrada: ($day-$month2-$year)")
    }

    //Fecha de Salida
    private fun showDatePickerDialog2() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected2(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
    private fun onDateSelected2(day: Int, month: Int, year: Int) {
        val etDate2 = findViewById<EditText>(R.id.etDate2)
        val month2 = month+1
        etDate2.setText("Fecha de salida: ($day-$month2-$year)")
    }
}