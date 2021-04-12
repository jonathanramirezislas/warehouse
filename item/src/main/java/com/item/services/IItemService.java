package com.item.services;

import com.item.models.Item;
import com.item.models.Producto;

import java.util.List;

public interface IItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);

    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);
}
