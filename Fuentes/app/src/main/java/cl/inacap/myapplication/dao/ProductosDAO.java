package cl.inacap.myapplication.dao;

import java.util.List;

import cl.inacap.myapplication.dto.Producto;

public interface ProductosDAO {

    Producto save(Producto p);
    List<Producto> getAll();
}
