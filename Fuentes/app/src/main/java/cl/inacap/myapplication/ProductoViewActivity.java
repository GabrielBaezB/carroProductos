package cl.inacap.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.myapplication.dto.Producto;

public class ProductoViewActivity extends AppCompatActivity {

    TextView nombreProdTv;
    TextView descripcionproTV;
    ImageView imagenProd;
    TextView precioProTV;
    Producto producto;
    Toolbar toolbar; //appcompat
    TextView tituloToolbarTV;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_view);
        //referencia toolbar
        this.toolbar = findViewById(R.id.toolbar);
        this.tituloToolbarTV = findViewById(R.id.titulo_toolbar);

        this.nombreProdTv = findViewById(R.id.nombreProdView);
        this.imagenProd =  findViewById(R.id.imagen_prod_view);
        this.descripcionproTV = findViewById(R.id.desc_prod_view_tv);
        this.precioProTV = findViewById(R.id.precio_prod_view_tv);

        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        if(getIntent().getExtras() != null){
            this.producto = (Producto) getIntent().getSerializableExtra("producto");
            this.tituloToolbarTV.setText(this.producto.getNombre());
            this.nombreProdTv.setText(this.producto.getNombre());
            Picasso.get().load(this.producto.getFoto())
                    .resize(500, 500)
                    .centerCrop()
                    .into(this.imagenProd);
            this.descripcionproTV.setText(this.producto.getDescripcion());
            this.precioProTV.setText("$" + this.producto.getPrecio());
        }
    }
//
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}