package com.productos.controllers;

import com.productos.entities.Producto;
import com.productos.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    //@Autowired
    //private Environment env; //from env to get the port

   //@Value("${server.port}")
   //private Integer port; //simpler way to get the port use in onlye static port ;)

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar(){

        return productoService.findAll().stream().map(producto ->{
            //producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); //using env
            producto.setPort(webServerAppCtxt.getWebServer().getPort());
            return producto;
        }).collect(Collectors.toList());

    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort(webServerAppCtxt.getWebServer().getPort());
        return producto;
    }
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED) //response status
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);

    }

}

