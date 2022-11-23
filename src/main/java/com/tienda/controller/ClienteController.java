/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ivmor
 */
@Controller

public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    /*@GetMapping("/cliente/busqueda")
    public String buscar(Cliente cliente ){
        var clientes=clienteService.buscarxApellido(apellidos);*/
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
         var clientes = clienteService.getClientes();
         model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "cliente/modificar";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        
        return "/cliente/modificar";
                    
   
}
     @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminatCliente(Cliente cliente){
       clienteService.delete(cliente);
        return "redirect:/cliente/listado";
                    
}
}

