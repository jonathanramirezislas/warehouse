package com.productos.services;

import com.productos.entities.Producto;
import com.productos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRespository;

    @Override
    @Transactional(readOnly = true) //good practice improve performance
    public List<Producto> findAll() {
        return (List<Producto>) productoRespository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoRespository.findById(id).orElse(null);
    }
}