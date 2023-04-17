package com.example.myapplicationagendadatosguardados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_datos = (EditText) findViewById(R.id.et_datos);
    }
    public void guardar (View view) {
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "Tus datos se han guardado correctamente", Toast.LENGTH_LONG).show();

            }
    public  void Buscar (View view) {
        String nombre = et_nombre.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", MODE_PRIVATE);
        String datos = preferences.getString(nombre, "");

        if (datos.length() == 0) {
            Toast.makeText(this, "No se encontró ningún registro", Toast.LENGTH_LONG).show();
        } else {
            et_datos.setText(datos);
        }

    }
}