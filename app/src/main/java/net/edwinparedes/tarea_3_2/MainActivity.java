package net.edwinparedes.tarea_3_2;

import android.content.Intent;
import android.net.ParseException;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputEditText   tieNombreCompleto;
    DatePicker          datFechaNacimiento;
    TextInputEditText   tieTelefono;
    TextInputEditText   tieEmail;
    TextInputEditText   tieDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tieNombreCompleto   = (TextInputEditText)findViewById(R.id.tieNombreCompleto);
        datFechaNacimiento  = (DatePicker) findViewById(R.id.datFechaNacimiento);
        tieTelefono         = (TextInputEditText)findViewById(R.id.tieTelefono);
        tieEmail            = (TextInputEditText)findViewById(R.id.tieEmail);
        tieDescripcion      = (TextInputEditText)findViewById(R.id.tieDescripcion);


        try {
            Bundle par = getIntent().getExtras();

            String nombreCompleto = par.getString(getResources().getString(R.string.parNombreCompleto));
            String fechaNacimiento = par.getString(getResources().getString(R.string.parFechaNacimiento));
            String telefono = par.getString(getResources().getString(R.string.parTelefono));
            String email = par.getString(getResources().getString(R.string.parEmail));
            String descripcion = par.getString(getResources().getString(R.string.parDescripcion));


            tieNombreCompleto.setText(nombreCompleto);
            tieTelefono.setText(telefono);
            tieEmail.setText(email);
            tieDescripcion.setText(descripcion);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse(fechaNacimiento);

            Calendar c = Calendar.getInstance();
            c.setTime(fecha);


            datFechaNacimiento.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

            //Log.d("DIA", String.format("%2f",fecha.getDate() ));


        }
        catch (java.lang.RuntimeException ex){}
        catch (java.text.ParseException e) { e.printStackTrace(); }

    }

    public void onSiguiente(View v){

        Intent intent = new Intent(this, ConfirmarDatos.class);

        intent.putExtra(getResources().getString(R.string.parNombreCompleto)    , tieNombreCompleto.getText().toString());


        intent.putExtra(getResources().getString(R.string.parFechaNacimiento)   ,
                                              String.format("%02d" , datFechaNacimiento.getDayOfMonth()) + "/" +
                                              String.format("%02d" ,( datFechaNacimiento.getMonth() + 1)) + "/" +
                                              datFechaNacimiento.getYear()
        );
        intent.putExtra(getResources().getString(R.string.parTelefono)          , tieTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.parEmail)             , tieEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.parDescripcion)       , tieDescripcion.getText().toString());

        startActivity(intent);
        finish();

    }
}
