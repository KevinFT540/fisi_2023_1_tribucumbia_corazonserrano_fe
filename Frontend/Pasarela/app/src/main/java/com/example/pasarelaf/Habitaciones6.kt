package com.example.pasarelaf

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Habitaciones6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habitaciones5)

        val TamH = "30m2"
        val numhabit1 = findViewById<TextView>(R.id.numhabit1)
        val cd1 = findViewById<TextView>(R.id.cd1)
        val cp1 = findViewById<TextView>(R.id.cp1)
        val tamaño1 = findViewById<TextView>(R.id.tamaño1)
        val precio1 = findViewById<TextView>(R.id.precio1)
        val tipo1 = findViewById<TextView>(R.id.tipo1)


        val numhabit2 = findViewById<TextView>(R.id.numhabit2)
        val cd2 = findViewById<TextView>(R.id.cd2)
        val cp2 = findViewById<TextView>(R.id.cp2)
        val tamaño2 = findViewById<TextView>(R.id.tamaño2)
        val precio2 = findViewById<TextView>(R.id.precio2)
        val tipo2 = findViewById<TextView>(R.id.tipo2)


        val numhabit3 = findViewById<TextView>(R.id.numhabit3)
        val cd3 = findViewById<TextView>(R.id.cd3)
        val cp3 = findViewById<TextView>(R.id.cp3)
        val tamaño3 = findViewById<TextView>(R.id.tamaño3)
        val precio3 = findViewById<TextView>(R.id.precio3)
        val tipo3 = findViewById<TextView>(R.id.tipo3)


        val numhabit4 = findViewById<TextView>(R.id.numhabit4)
        val cd4 = findViewById<TextView>(R.id.cd4)
        val cp4 = findViewById<TextView>(R.id.cp4)
        val tamaño4 = findViewById<TextView>(R.id.tamaño4)
        val precio4 = findViewById<TextView>(R.id.precio4)
        val tipo4 = findViewById<TextView>(R.id.tipo4)


        val numhabit5 = findViewById<TextView>(R.id.numhabit5)
        val cd5 = findViewById<TextView>(R.id.cd5)
        val cp5 = findViewById<TextView>(R.id.cp5)
        val tamaño5 = findViewById<TextView>(R.id.tamaño5)
        val precio5 = findViewById<TextView>(R.id.precio5)
        val tipo5 = findViewById<TextView>(R.id.tipo5)

        val numhabit6 = findViewById<TextView>(R.id.numhabit6)
        val cd6 = findViewById<TextView>(R.id.cd6)
        val cp6 = findViewById<TextView>(R.id.cp6)
        val tamaño6 = findViewById<TextView>(R.id.tamaño6)
        val precio6 = findViewById<TextView>(R.id.precio6)
        val tipo6 = findViewById<TextView>(R.id.tipo6)

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.36:8080/api/reservar/v1/habitacion"
//        val url = "http://20.121.72.196:3000/api/reservar/v1/habitacion"

        val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
            val jsonObject = JSONObject(response)

            val algoy = jsonObject.getJSONArray("datos")
            for(i in 0 until algoy.length()){
                val algo2 = algoy.getJSONObject(i)

                val algo3 = algo2.getInt("habitacionId")
                val algo4 = algo2.getString("camasDoble")
                val algo5 = algo2.getString("camasPersonales")
                val algo6 = algo2.getString("tamaño")
                val algo7 = algo2.getString("precio")
                val algo8 = algo2.getString("tipo")

                when(algo2.getInt("habitacionId") ){
                    53-> {
                        numhabit1.text = algo3.toString()
                        cd1.text = algo4.toString()
                        cp1.text = algo5.toString()
                        tamaño1.text = algo6.toString()
                        precio1.text = "S/ " +algo7.toString()
                        tipo1.text =algo8.toString()
                    }
                    54->{
                        numhabit2.text = algo3.toString()
                        cd2.text = algo4.toString()
                        cp2.text = algo5.toString()
                        tamaño2.text = algo6.toString()
                        precio2.text = "S/ " +algo7.toString()
                        tipo2.text =algo8.toString()
                    }
                    55->{
                        numhabit3.text = algo3.toString()
                        cd3.text = algo4.toString()
                        cp3.text = algo5.toString()
                        tamaño3.text = algo6.toString()
                        precio3.text = "S/ " +algo7.toString()
                        tipo3.text =algo8.toString()
                    }
                    56->{
                        numhabit4.text = algo3.toString()
                        cd4.text = algo4.toString()
                        cp4.text = algo5.toString()
                        tamaño4.text = algo6.toString()
                        precio4.text = "S/ " +algo7.toString()
                        tipo4.text =algo8.toString()
                    }
                    57->{
                        numhabit5.text = algo3.toString()
                        cd5.text = algo4.toString()
                        cp5.text = algo5.toString()
                        tamaño5.text = algo6.toString()
                        precio5.text ="S/ " + algo7.toString()
                        tipo5.text =algo8.toString()
                    }
                    58->{
                        numhabit6.text = algo3.toString()
                        cd6.text = algo4.toString()
                        cp6.text = algo5.toString()
                        tamaño6.text = algo6.toString()
                        precio6.text ="S/ " + algo7.toString()
                        tipo6.text =algo8.toString()
                    }
                }
            }

        }, Response.ErrorListener { error ->
            Toast.makeText(applicationContext, "Error de conexión", Toast.LENGTH_SHORT).show();
        })
        queue.add(stringRequest)

    }


    fun regresar (view: View){
        finish()
    }

    fun usuariohabit6(view: View){
        val ushabit6 = Intent(this,Perfil::class.java)
        startActivity(ushabit6)
    }
}

