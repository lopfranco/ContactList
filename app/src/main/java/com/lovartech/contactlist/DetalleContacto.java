package com.lovartech.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalleContacto extends AppCompatActivity {

    Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("MiNombreCompleto");
        String fecha = parametros.getString("MiFechaNacimiento");
        String telefono = parametros.getString("MiTelefono");
        String email = parametros.getString("MiCorreo");
        String descripcion = parametros.getString("MiDescripcion");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView) findViewById(R.id.tvFecha);
        TextView tvTelefon = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefon.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);



        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleContacto.this, VistaContacto.class);
                startActivity(i);
                Log.d("Intent","Intent para regresar a la Vista General");
            }
        });
    }
}
