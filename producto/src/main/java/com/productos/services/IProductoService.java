package com.productos.services;

import com.commonsservice.entities.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);

}
