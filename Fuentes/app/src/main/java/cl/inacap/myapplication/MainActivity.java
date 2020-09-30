package cl.inacap.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cl.inacap.myapplication.adapters.ProductosListAdapter;
import cl.inacap.myapplication.dao.ProductosDAO;
import cl.inacap.myapplication.dao.ProductosDAOLista;
import cl.inacap.myapplication.dto.Producto;

public class MainActivity extends AppCompatActivity {

    private List<Producto> productos;
    private ProductosDAO prodDAO = ProductosDAOLista.getInstance();
    private ListView productosLV;

    private ProductosListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.productos = this.prodDAO.getAll();
        this.productosLV = findViewById(R.id.productos_lv);
        this.adapter = new ProductosListAdapter(this, R.layout.productos_list, this.productos);
        this.productosLV.setAdapter(this.adapter);
        // Agrega un listener a los elementos de la lista
        //Clase anonima, construir una clase en el codigo que implenta la interfaz
        this.productosLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Producto producto = productos.get(i);
                //1. como lo mando al otro activity
                //2. como hago que vaya al otro activity?

                //Intent--> des donde viene(contexto), Hacia donde va el (contexto)
                Intent intent = new Intent(MainActivity.this, ProductoViewActivity.class);

                //para mandar elementos
                intent.putExtra("producto", producto);


                startActivity(intent);

            }


        });

    }
}