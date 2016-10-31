package com.example.hellen.proyecto_agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class Agregar extends ActionBarActivity {

    MyDBHandler dbHandler;
    EditText txt_T;
    EditText txt_Hora;
    EditText txt_Lugar;
    EditText txt_Descrip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        txt_T = (EditText) findViewById(R.id.txt_T);
        txt_Hora = (EditText) findViewById(R.id.txt_Hora);
        txt_Lugar = (EditText) findViewById(R.id.txt_Lugar);
        txt_Descrip = (EditText) findViewById(R.id.txt_Descrip);
        dbHandler = new MyDBHandler(this, null, null, 1);
    }

    //Añade una Persona a la Base de Datos

   public void agregar_clicked(View view){

    Datos persona = new Datos( txt_T.getText().toString(), Integer.parseInt( txt_Hora.getText().toString()), txt_Lugar.getText().toString(),txt_Descrip.getText().toString());
       dbHandler.addPersona(persona);
       confirmacion();
       limpiarcampos();
   }


   //Limpia los valores entrados para efectos de estetica
   public void limpiarcampos(){

       txt_T.setText("");
       txt_Hora.setText("");
       txt_Lugar.setText("");
       txt_Descrip.setText("");

   }

   public void confirmacion(){

       AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
       dlgAlert.setMessage("Se ha agregado exitosamente!");
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

}
