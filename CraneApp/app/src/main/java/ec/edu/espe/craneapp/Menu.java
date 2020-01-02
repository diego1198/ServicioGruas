package ec.edu.espe.craneapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button btnOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnOperator = findViewById(R.id.btnOperator);
        btnOperator.setOnClickListener(this);
    }
    public void onBackPressed() {
        finish();

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==btnOperator.getId()){
            Intent i = new Intent(getApplicationContext(), OperatorActivity.class);
            startActivity(i);
            finish();
        }

    }


}
