package com.example.servigruas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button aceptarLogin;
    private  EditText txtUsu, txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Enlaces con elementos visuales
        txtUsu = (EditText)findViewById(R.id.txtUsuario);
        txtPass = (EditText)findViewById(R.id.txtContraseña);
        aceptarLogin = findViewById(R.id.btnIngresarLogin); //enlaza la parte gráfica con el código

        //Listener de los botones
        aceptarLogin.setOnClickListener( this); //habilita el evento onclicklistener

    }

    public void onBackPressed() {

        finish();
    }
    public void onClick(View view)
    {

    }

}
