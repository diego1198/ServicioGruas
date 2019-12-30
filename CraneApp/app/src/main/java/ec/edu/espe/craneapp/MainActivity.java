package ec.edu.espe.craneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLogin;
    private EditText txtUsu, txtPass;
    private ConnectivityManager connec;
    private Boolean datosMoviles;
    private Boolean  wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlaza la parte gráfica con el código
        txtUsu = (EditText)findViewById(R.id.txtUsuario);
        txtPass = (EditText)findViewById(R.id.txtContraseña);
        btnLogin = findViewById(R.id.btnIngresarLogin);

        //Listener de los botones
        //habilita el evento onclicklistener
        btnLogin.setOnClickListener(this);

        //comprobar conexion
        connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        datosMoviles = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        wifi= connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();


    }

    public void onBackPressed() {
        finish();

    }
    public void onClick(View view)
    {
        if (datosMoviles ||wifi) {
            Intent i = new Intent(getApplicationContext(),Menu.class);
            //putExtra --> envia datos de un activity a otro (nombrevariable,valor de la variable)
            i.putExtra("CI_OPERADOR",txtUsu.getText().toString());
            startActivity(i);
            finish();
        }else {
            Toast.makeText(getBaseContext(),"Necesaria conexión a internet ", Toast.LENGTH_SHORT).show();
        }
    }



}
