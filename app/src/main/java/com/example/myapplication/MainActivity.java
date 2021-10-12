package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextInputEditText txtNombre;
    DatePicker dtFechaNac;
    TextInputEditText txtTelefono;
    TextInputEditText txtEmail;
    TextInputEditText txtDescripcion;
    Button btnSiguiente;
    Contacto contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contacto = new Contacto();
        setContentView(R.layout.actividad_principal);
        txtNombre = findViewById(R.id.txtNombre);
        dtFechaNac = findViewById(R.id.dtFechaNac);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        btnSiguiente =  findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        Calendar tmpDate = Calendar.getInstance(new Locale("es","mx"));
        tmpDate.set(dtFechaNac.getYear(),dtFechaNac.getMonth(),dtFechaNac.getDayOfMonth());

        contacto.setNombre(txtNombre.getText().toString());
        contacto.setFechaNacimiento(tmpDate);
        contacto.setTelefono(txtTelefono.getText().toString());
        contacto.setEmail(txtEmail.getText().toString());
        contacto.setDescripcion(txtDescripcion.getText().toString());

        Log.d("jhcok", "onClick: ok" + contacto);
        Intent intent = new Intent(MainActivity.this , ConfirmacionContacto.class );
        intent.putExtra("nombre",contacto.getNombre());
        intent.putExtra("fecha",contacto.getStringDate());
        intent.putExtra("telefono",contacto.getTelefono());
        intent.putExtra("email",contacto.getEmail());
        intent.putExtra("descripcion",contacto.getDescripcion());

        startActivity(intent);


    }
}