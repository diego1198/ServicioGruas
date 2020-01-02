package ec.edu.espe.craneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;


public class OperatorActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private  FloatingActionsMenu grupoBotones;
    private FloatingActionButton  btnmenu,btnlist,btnupdate,btninsert;
    private Spinner spinnerCraneManager;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);


        grupoBotones = findViewById(R.id.idfuncionesOperator);
        btnmenu=findViewById(R.id.idIrMenu);
        btnlist=findViewById(R.id.idIrListarOperator);
        btnupdate=findViewById(R.id.idIrActualizarOperator);
        btninsert=findViewById(R.id.idIrInsertarOperator);
        spinnerCraneManager =findViewById(R.id.spinnerCraneManager);

        //Listener de los botones
        //habilita el evento onclicklistener
        btnmenu.setOnClickListener(this);
        btnlist.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btninsert.setOnClickListener(this);
        spinnerCraneManager.setOnItemSelectedListener(this);

        getCraneManager();
        ArrayAdapter<CharSequence> opcionesCraneManager=new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        spinnerCraneManager.setAdapter(opcionesCraneManager);
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
            Intent iInsert = new Intent(getApplicationContext(), OperatorActivity.class);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void getCraneManager(){
        String sql="http://localhost:8080/Gruas/beta/CraneManager";

        StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url=null;
        HttpURLConnection conn ;

        try {
            url=new URL(sql);
            conn =(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response=new StringBuffer();

            while((inputLine=in.readLine())!=null){
                response.append(inputLine);

            }
            String json=response.toString();
            JSONArray jsonArray = new JSONArray(json);

            list.add("SELECT CRANE MANAGER");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                list.add(jsonObject.optString("cmid"));
                Log.d("RESPUESTA",jsonObject.optString("cmid"));

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
