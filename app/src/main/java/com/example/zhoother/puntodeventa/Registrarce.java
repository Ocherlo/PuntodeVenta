package com.example.zhoother.puntodeventa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registrarce extends AppCompatActivity {

    Button grabar;
    EditText txtNomUsu,txtCorUsu,txtPassUsu;
    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"bd1",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarce);

        grabar=(Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu=(EditText)findViewById(R.id.txtNomUsu);
        txtCorUsu=(EditText)findViewById(R.id.txtCorUsu);
        txtPassUsu=(EditText)findViewById(R.id.txtPassUsu);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helper.abrir();
                //helper.insertar(String.valueOf(txtNomUsu.getText()),String.valueOf(txtCorUsu.getText()),String.valueOf(txtPassUsu.getText()));
                //helper.close();
                //Toast.makeText(getApplicationContext(),"Registro éxitoso",Toast.LENGTH_LONG).show();
                //Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                //startActivity(i);
                EditText txtusu= findViewById(R.id.txtNomUsu);
                EditText txtpas= findViewById(R.id.txtPassUsu);
                EditText txtcor= findViewById(R.id.txtCorUsu);
                Cursor cursor1 = helper.consultar1(txtusu.getText().toString(), txtcor.getText().toString());
                if (cursor1.getCount()>0){
                    Toast.makeText(getApplicationContext(),"Usuario y/o correo ya registrados",
                            Toast.LENGTH_LONG).show();
                }else{
                    helper.abrir();
                    helper.insertar(String.valueOf(txtNomUsu.getText()),String.valueOf(txtCorUsu.getText()),String.valueOf(txtPassUsu.getText()));
                    helper.close();
                    Toast.makeText(getApplicationContext(),"Registro éxitoso",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                }
                txtusu.setText("");
                txtpas.setText("");
                txtusu.findFocus();
            }
        });

    }
}
