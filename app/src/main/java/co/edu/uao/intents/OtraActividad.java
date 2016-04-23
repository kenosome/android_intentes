package co.edu.uao.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by jileon on 23/04/2016.
 */
public class OtraActividad extends Activity {

    TextView salida;
    EditText color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin1);

//        referencias a los objetos del skin
        salida = (TextView) findViewById(R.id.salida);
        color = (EditText) findViewById(R.id.color);

        //se combierte el objeto serializado a un objeto tipo persona
        Persona p = (Persona) getIntent().getExtras().getSerializable("persona");

//        String nombre = getIntent().getExtras().getString("nombre","NO_NAME");
//        String cedula = getIntent().getExtras().getString("cedula","NO_CEDULA");

        if (p != null){
            Calendar calendar = Calendar.getInstance();
            int hora = calendar.get(calendar.HOUR_OF_DAY);
            int minutos = calendar.get(calendar.MINUTE);
            String str_horas = hora + ":" + minutos;
            salida.setText(str_horas + " -> Su nombre es " + p.getNombre() + " y su cedula es " + p.getCedula());
        }

    }

    public void aceptarColor(View view) {
        Intent i = new Intent();
        i.putExtra("color", color.getText().toString());
        setResult(10, i);

        //para finalizar la actividad hasta el destroy
        finish();
    }
}
