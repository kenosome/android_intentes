package co.edu.uao.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by jileon on 23/04/2016.
 */
public class OtraActividad extends Activity {

    TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin1);

        salida = (TextView) findViewById(R.id.salida);

        //se combierte el objeto serializado a un objeto tipo persona
        Persona p = (Persona) getIntent().getExtras().getSerializable("persona");

//        String nombre = getIntent().getExtras().getString("nombre","NO_NAME");
//        String cedula = getIntent().getExtras().getString("cedula","NO_CEDULA");

        salida.setText("Su nombre es " + p.getNombre() + " y su cedula es " + p.getCedula());
    }
}
