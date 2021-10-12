package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ConfirmacionContacto extends AppCompatActivity {
    TextView txtNombreConf;
    TextView dtFechaNacConf;
    TextView txtTelefonoConf;
    TextView txtEmailConf;
    TextView txtDescripcionConf;
    Button btnEditar;

    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_contacto);
        parametros = getIntent().getExtras();

        txtNombreConf = findViewById(R.id.txtNombreConf);
        dtFechaNacConf = findViewById(R.id.dtFechaNacConf);
        txtTelefonoConf = findViewById(R.id.txtTelefonoConf);
        txtEmailConf = findViewById(R.id.txtEmailConf);
        txtDescripcionConf = findViewById(R.id.txtDescripcionConf);
        btnEditar = findViewById(R.id.btnEditar);

        setParametros();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmacionContacto.this , MainActivity.class);

                startActivity(intent);;
            }
        });

    }

    private void  setParametros(){
        txtNombreConf.setText(parametros.getString("nombre"));
        dtFechaNacConf.setText(parametros.getString("fecha"));
        txtTelefonoConf.setText(parametros.getString("telefono"));
        txtEmailConf.setText(parametros.getString("email"));
        txtDescripcionConf.setText(parametros.getString("descripcion"));
    }
}