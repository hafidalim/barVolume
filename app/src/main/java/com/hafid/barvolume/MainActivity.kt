package com.hafid.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtPanjang : EditText
    private lateinit var edtLebar : EditText
    private lateinit var edtTinggi : EditText
    private lateinit var btnHitung : Button
    private lateinit var tvHasil : TextView

    companion object val STAT_RESULT = "state_result"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtPanjang = findViewById(R.id.edtPanjang)
        edtLebar = findViewById(R.id.edtLebar)
        edtTinggi = findViewById(R.id.edtTinggi)
        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)

        btnHitung.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STAT_RESULT) as String
            tvHasil.text = result
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(STAT_RESULT, tvHasil.text.toString())
    }


    override fun onClick(v: View?) {
        if (v?.id == R.id.btnHitung){
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var isEmptyField = false

            if (inputPanjang.isEmpty()){
                isEmptyField = true
                edtPanjang.error = "field panjang tidak boleh kosong"
            }
            if (inputLebar.isEmpty()){
                isEmptyField = true
                edtLebar.error = "field lebar tidak boleh kosong"
            }
            if (inputTinggi.isEmpty()){
                isEmptyField = true
                edtTinggi.error = "field tinggi tidak boleh kosong"
            }
            if (!isEmptyField){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()

                tvHasil.text = volume.toString()
            }
        }
    }
}
