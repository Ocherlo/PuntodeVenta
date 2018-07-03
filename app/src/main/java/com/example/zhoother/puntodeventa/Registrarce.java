package com.example.zhoother.puntodeventa;

import android.content.Intent;
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
                helper.abrir();
                helper.insertar(String.valueOf(txtNomUsu.getText()),String.valueOf(txtCorUsu.getText()),String.valueOf(txtPassUsu.getText()));
                helper.close();
                Toast.makeText(getApplicationContext(),"Registro éxitoso",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
