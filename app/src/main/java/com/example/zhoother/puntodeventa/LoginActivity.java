package com.example.zhoother.puntodeventa;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import OpenHelper.SQLite_OpenHelper;

public class LoginActivity extends Activity {

    TextView tvRegistrece,tvRecuPass;
    Button btnIngresar;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"bd1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegistrece=(TextView)findViewById(R.id.tvRegistrece);
        tvRegistrece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Registrarce.class);
                startActivity(i);
            }
        });
        
        tvRecuPass=(TextView)findViewById(R.id.tvRecupePass);
        tvRecuPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Recuperar.class);
                startActivity(i);
            }
        });

        btnIngresar= findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu= findViewById(R.id.txtUsuario);
                EditText txtpas= findViewById(R.id.txtPassword);
                Cursor cursor = helper.consultar(txtusu.getText().toString(), txtpas.getText().toString());
                if (cursor.getCount()>0){
                    Intent i=new Intent(getApplicationContext(),BasicActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario y/o Contraseña Incorrectos",
                            Toast.LENGTH_LONG).show();
                }
                txtusu.setText("");
                txtpas.setText("");
                txtusu.findFocus();


            }
        });
    }
}
