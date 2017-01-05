package net.edwinparedes.tarea_3_2;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombreCompleto;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        Bundle par = getIntent().getExtras();

        String nombreCompleto   = par.getString(getResources().getString(R.string.parNombreCompleto));
        String fechaNacimiento  = getResources().getString(R.string.txtFechaNacimiento) + ": "  +  par.getString(getResources().getString(R.string.parFechaNacimiento));
        String telefono         = getResources().getString(R.string.txtTelefono) + ": "  +  par.getString(getResources().getString(R.string.parTelefono));
        String email            = getResources().getString(R.string.txtEmail) + ": "  +  par.getString(getResources().getString(R.string.parEmail));
        String descripcion      = getResources().getString(R.string.txtDescripcion) + ": "  +  par.getString(getResources().getString(R.string.parDescripcion));


        tvNombreCompleto.setText(nombreCompleto);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

    }

    public void editarDatos(View v){

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(getResources().getString(R.string.parNombreCompleto)    , tvNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.parFechaNacimiento)   , tvFechaNacimiento.getText().toString().replace(getResources().getString(R.string.txtFechaNacimiento) + ": ", ""));
        intent.putExtra(getResources().getString(R.string.parTelefono)          , tvTelefono.getText().toString().replace(getResources().getString(R.string.txtTelefono) + ": ", ""));
        intent.putExtra(getResources().getString(R.string.parEmail)             , tvEmail.getText().toString().replace(getResources().getString(R.string.txtEmail) + ": ", ""));
        intent.putExtra(getResources().getString(R.string.parDescripcion)       , tvDescripcion.getText().toString().replace(getResources().getString(R.string.txtDescripcion) + ": ", ""));

        startActivity(intent);
        finish();
    }
}
