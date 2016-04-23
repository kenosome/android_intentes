package co.edu.uao.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

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

        String nombre = getIntent().getExtras().getString("nombre","NO_NAME");
        String cedula = getIntent().getExtras().getString("cedula","NO_CEDULA");

        salida.setText("Su nombre es " + nombre + " y su cedula es " + cedula);
    }
}
