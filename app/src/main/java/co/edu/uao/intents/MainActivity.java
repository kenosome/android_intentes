package co.edu.uao.intents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText nombre, cedula;
    LinearLayout layout_padre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        cedula = (EditText) findViewById(R.id.cedula);
        layout_padre = (LinearLayout) findViewById(R.id.layout_padre);
    }


    //este se puede crear con el bombillo desde el XML
    public void enviarParametros(View view) {
        Intent i = new Intent(this, OtraActividad.class);

        Persona p = new Persona(nombre.getText().toString(),cedula.getText().toString());
        i.putExtra("persona", p);
        //i.putExtra("nombre", nombre.getText().toString());
        //i.putExtra("cedula", cedula.getText().toString());

        startActivityForResult(i, 10);
     }

    //con este metodo se reciben toods los resultados de las actividades lanzadas desde la main y se define que hacer segun cada codigo de result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 10){
            //esto es como un alert para mostrar avisos en pantalla
            //Toast.makeText(this, "recibido", Toast.LENGTH_SHORT).show();

            String color = data.getExtras().getString("color","NO_COLOR");

            if (color.equalsIgnoreCase("Negro")){
                layout_padre.setBackgroundColor(Color.BLACK);
            } else if (color.equalsIgnoreCase("Azul")){
                layout_padre.setBackgroundColor(Color.BLUE);
            } else {
                layout_padre.setBackgroundColor(Color.WHITE);
            }
            return;

        }
    }
}
