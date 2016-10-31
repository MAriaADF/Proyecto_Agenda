package com.example.hellen.proyecto_agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class modificar extends ActionBarActivity {

    MyDBHandler dbHandler;
    EditText txt_T;
    EditText txt_Hora;
    EditText txt_Lugar;
    EditText txt_Descrip;
    int idglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Aqui se hace el retrieve de la base de datos tomando un valor que viene en el intent anterior

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        txt_T = (EditText) findViewById(R.id.txt_T);
        txt_Hora = (EditText) findViewById(R.id.txt_Hora);
        txt_Lugar = (EditText) findViewById(R.id.txt_Lugar);
        txt_Descrip = (EditText) findViewById(R.id.txt_Descrip);
        dbHandler = new MyDBHandler(this, null, null, 1);
        Datos persona = new Datos();
        Intent i = getIntent(); // gets the previously created intent
        String stringid = i.getStringExtra("id_persona");
        int id = Integer.parseInt(stringid);
        Cursor c = dbHandler.personabyid(id);

    //Vuelve a rellenar los inputs con los valores del cursor
        txt_T.setText(c.getString(c.getColumnIndexOrThrow("Titulo")));
        txt_Hora.setText(c.getString(c.getColumnIndexOrThrow("Hora")));
        txt_Lugar.setText(c.getString(c.getColumnIndexOrThrow("Lugar")));
        txt_Descrip.setText(c.getString(c.getColumnIndexOrThrow("Descripcion")));
        idglobal = c.getInt(c.getColumnIndexOrThrow("Id_Datos"));

    }

    public void modificar_clicked(View view){

        Datos persona = new Datos(txt_T.getText().toString(), Integer.parseInt( txt_Hora.getText().toString()), txt_Lugar.getText().toString(),txt_Descrip.getText().toString());
        persona.set_id(idglobal);
        dbHandler.updatepersona(persona);
        confirmacion();
        limpiarcampos();
        finish(); //Termina la actividad y vuelve al menu principal

        }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        txt_T.setText("");
        txt_Hora.setText("");
        txt_Lugar.setText("");
        txt_Descrip.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
