package com.ra.parcial_1_empresaalimentaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtId;
    EditText txtPrecio;
    CheckBox checkIva;
    Spinner spinnerCategorias;
    EditText txtDescripcion;
    TextView txtMesanje;
    Button btnGuradar;
    Button btnMasCostoso;
    Button btnMenosCostoso;
    Button btnPromedio;



    ArrayList<Producto>listaProductos =new ArrayList();
    ArrayList<Integer>listaOrdenadaAcendente = new ArrayList();
    ArrayList<Integer>listaOrdenadaDecendete = new ArrayList();
    ArrayList<Integer>listaOrdenadaProm = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtPrecio = findViewById(R.id.txtPrecio);
        checkIva = findViewById(R.id.checkIva);
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        txtDescripcion = findViewById(R.id.txtDescrpcion);
        txtMesanje = findViewById(R.id.txtMesanje);

        btnGuradar = findViewById(R.id.btnGuradar);
        btnMasCostoso = findViewById(R.id.btnMasCostoso);
        btnMenosCostoso = findViewById(R.id.btnMenosCostoso);
        btnPromedio = findViewById(R.id.btnPromedio);

        btnGuradar.setOnClickListener(this);
        btnMasCostoso.setOnClickListener(this);
        btnMenosCostoso.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuradar){
            Integer Id = Integer.parseInt(txtId.getText().toString());
            Integer Precio = Integer.parseInt(txtPrecio.getText().toString());
            boolean IVA = checkIva.isChecked();
            String Categoria = spinnerCategorias.getSelectedItem().toString();
            String Descripcion = txtDescripcion.getText().toString();

            Producto objProducto = new Producto(Id, Precio, IVA, Categoria, Descripcion);
            listaProductos.add(objProducto);

            String mensaje = "";

            for (int i = 0; i < listaProductos.size(); i++){
                mensaje = listaProductos.get(i).toString();
            }
            txtMesanje.setText(mensaje);
        }
        else if (v.getId() == R.id.btnMasCostoso){
            ordenarPreciosMayor();
            for (int i = 0; i < listaOrdenadaDecendete.size(); i++) {
                txtMesanje.setText(listaOrdenadaDecendete.toString());
            }
        }
        else if (v.getId() == R.id.btnMenosCostoso){
            ordenarPreciosMenor();
            for (int i = 0; i < listaOrdenadaAcendente.size(); i++) {
                txtMesanje.setText(listaOrdenadaAcendente.toString());
            }

        }
        else if (v.getId() == R.id.btnPromedio){
            double sumPrecios = 0;
            double promedio;
            for (int i = 0; i < listaOrdenadaProm.size(); i++) {
                sumPrecios =sumPrecios+listaOrdenadaProm.get(i);
            }
            promedio = sumPrecios/listaOrdenadaProm.size();
            txtMesanje.setText(String.valueOf(promedio));

        }
    }
    public ArrayList ordenarPreciosMayor(){
        for (int i = 0; i < listaProductos.size(); i++) {
            listaOrdenadaDecendete.add(listaProductos.get(i).getValor());
            listaOrdenadaProm.add(listaProductos.get(i).getValor());
        }
        Collections.reverse(listaOrdenadaDecendete);
        return listaOrdenadaDecendete;
    }

    public ArrayList ordenarPreciosMenor(){
        for (int i = 0; i < listaProductos.size(); i++) {
            listaOrdenadaAcendente.add(listaProductos.get(i).getValor());
        }
        Collections.sort(listaOrdenadaAcendente);
        return listaOrdenadaAcendente;
    }


}