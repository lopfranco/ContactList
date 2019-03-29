package com.lovartech.contactlist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class VistaContacto extends AppCompatActivity implements View.OnClickListener {

    Button btnSiguiente;
    EditText nombre;
    EditText fecha;
    EditText telefono;
    EditText email;
    EditText descripcion;

    private static final String CERO = "0";
    private static final String BARRA = "/";

    public final Calendar c = Calendar.getInstance();

    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_contacto);

        fecha = (EditText) findViewById(R.id.etFecha);
        nombre = (EditText) findViewById(R.id.etNombreCompleto);
        telefono = (EditText) findViewById(R.id.edTelefono);
        email = (EditText) findViewById(R.id.edEmail);
        descripcion = (EditText) findViewById(R.id.etDescripcion);

        fecha.setOnClickListener(this);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VistaContacto.this, DetalleContacto.class);
                intent.putExtra("MiNombreCompleto", nombre.getText().toString());
                intent.putExtra("MiFechaNacimiento", fecha.getText().toString());
                intent.putExtra("MiTelefono",telefono.getText().toString());
                intent.putExtra("MiCorreo",email.getText().toString());
                intent.putExtra("MiDescripcion",descripcion.getText().toString());

                startActivity(intent);
                Log.d("Intent","Intent para pantalla de Edicion");
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etFecha:
                muestraCalendario();
                break;
        }
    }


    private void muestraCalendario(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                fecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
        },anio, mes, dia);
        recogerFecha.show();

    }



}
