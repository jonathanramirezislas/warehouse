package com.item.cliente;


import com.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//nombre del microservicio //direccion+port
//@FeignClient(name = "servicio-productos", url="localhost:8001")
@FeignClient(name = "servicio-productos") //with ribbon urls will be in application.properties so far..
public interface IProductoClienteRest {

                //endpoint del microservicio
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto producto);

    @PutMapping("/editar/{id}")
    public Producto update(@RequestBody Producto producto, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id);

    @GetMapping("/testinghystrix")
    public Producto testinghystrix();



}
