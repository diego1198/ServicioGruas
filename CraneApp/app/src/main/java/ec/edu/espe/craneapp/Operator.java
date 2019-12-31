package ec.edu.espe.craneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class Operator extends AppCompatActivity implements View.OnClickListener{

    private  FloatingActionsMenu grupoBotones;
    private FloatingActionButton  btnmenu,btnlist,btnupdate,btninsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);



        grupoBotones = findViewById(R.id.idfuncionesOperator);
        btnmenu=findViewById(R.id.idIrMenu);
        btnlist=findViewById(R.id.idIrListarOperator);
        btnupdate=findViewById(R.id.idIrActualizarOperator);
        btninsert=findViewById(R.id.idIrInsertarOperator);

        //Listener de los botones
        //habilita el evento onclicklistener

        btnmenu.setOnClickListener(this);
        btnlist.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btninsert.setOnClickListener(this);
    }
    public void onBackPressed() {
        finish();

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==btnlist.getId()){
            Intent iList = new Intent(getApplicationContext(),OperatorListActivity.class);
            startActivity(iList);
            finish();
            grupoBotones.collapse();

        }
        if(v.getId()==btninsert.getId()){
            Intent iInsert = new Intent(getApplicationContext(),Operator.class);
            startActivity(iInsert);
            finish();
            grupoBotones.collapse();

        }
        if(v.getId()==btnupdate.getId()){
            Intent iUpdate = new Intent(getApplicationContext(),OperatorUpdateActivity.class);
            startActivity(iUpdate);
            finish();
            grupoBotones.collapse();

        }
        if(v.getId()==btnmenu.getId()){
            Intent iUpdate = new Intent(getApplicationContext(),Menu.class);
            startActivity(iUpdate);
            finish();
            grupoBotones.collapse();

        }


    }
}
