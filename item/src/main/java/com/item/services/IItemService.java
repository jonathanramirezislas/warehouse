package com.item.services;

import com.item.models.Item;

import java.util.List;

public interface IItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
}
