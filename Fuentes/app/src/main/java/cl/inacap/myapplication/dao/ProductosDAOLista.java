package cl.inacap.myapplication.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.myapplication.dto.Producto;

public class ProductosDAOLista implements ProductosDAO{
    private static List<Producto> productos = new ArrayList<>();
    /* Patron Singleton
    * 1. Una instancia como atributo estatico de si misma
    * 2. El constructor deber ser privado
    * 3. Debe existir un metodo que verifiue la existencia de la unica instancia (getInstance)
    * */

    private static ProductosDAOLista instancia;

    public static ProductosDAOLista getInstance(){
        if(instancia == null){
            instancia =  new ProductosDAOLista();
        }
        return instancia;
    }

    private ProductosDAOLista(){
        Producto p =  new Producto();
        p.setNombre("Coca Cola");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla commodo leo metus, a interdum diam facilisis id. Donec porta tincidunt consequat. Vestibulum tincidunt");
        p.setPrecio(1000);
        p.setFoto("https://images.heb.com/is/image/HEBGrocery/001397056");
        productos.add(p);

        p = new Producto();
        p.setNombre("Centella");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla commodo leo metus, a interdum diam facilisis id. Donec porta tincidunt consequat. Vestibulum tincidunt");
        p.setPrecio(100);
        p.setFoto("https://dojiw2m9tvv09.cloudfront.net/21884/product/X_4_20817.png?56");
        productos.add(p);

        p = new Producto();
        p.setNombre("Ramitas de Queso");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla commodo leo metus, a interdum diam facilisis id. Donec porta tincidunt consequat. Vestibulum tincidunt");
        p.setPrecio(500);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/308513/Ramitas-saladas-Cuisine---Co-270-g-1-97912959.jpg?v=636996691044030000");
        productos.add(p);

        p = new Producto();
        p.setNombre("chocolate");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla commodo leo metus, a interdum diam facilisis id. Donec porta tincidunt consequat. Vestibulum tincidunt");
        p.setPrecio(10000);
        p.setFoto("https://images-na.ssl-images-amazon.com/images/I/917A17ceslL._SL1500_.jpg");
        productos.add(p);
    }

    @Override
    public Producto save(Producto p) {
       return null;
    }

    @Override
    public List<Producto> getAll() {
        return productos;
    }
}
