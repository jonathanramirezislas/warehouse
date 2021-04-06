package com.item.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.item.models.Item;
import com.item.models.Producto;
import com.item.services.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    private static Logger log = LoggerFactory.getLogger(ItemController.class);



    @Autowired
    @Qualifier("serviceFeign")
    private IItemService itemService;

    //leyendo propiedades forma 1
    @Value("${configuracion.texto}")
    private String texto;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();

    }
    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    //Testing hystrix to provide  a bug test
    @HystrixCommand(fallbackMethod = "testmetodoAlternativo")
    @GetMapping("/testinghystrix")
    public Item testinghystrix() {
        return itemService.findById(1L, 0);
    }

    public Item metodoAlternativo(Long id, Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("producto de prueba a errores");
        producto.setPrecio(0.0);
        item.setProducto(producto);
        return item;

    }
    public Item testmetodoAlternativo() {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(0);
        producto.setId(1L);
        producto.setNombre("producto de prueba a errores");
        producto.setPrecio(0.0);
        item.setProducto(producto);
        return item;

    }

    @GetMapping("/obtener-config")          //leyendo propeidades forma 2
    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){

        log.info(texto);

        Map<String, String> json = new HashMap<>();
        json.put("texto", texto); //otenido de propiedades
        json.put("puerto", puerto);//obitenido de propiedades


        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }

}
