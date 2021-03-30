package com.item.services;

import com.item.models.Item;
import com.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService{


    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {              //obtenemos de otro microservicio la lista de productos                                                             //arreglo de producto
        List<Producto> productos = Arrays.asList(Objects.requireNonNull(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class)));

        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }
}




