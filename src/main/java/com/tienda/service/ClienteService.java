/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

/**
 *
 * @author ivmor
 */
public interface ClienteService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
   // public List <Cliente> buscarxApellido(String apellidos);
    //retorna la lista de clientes
    public List<Cliente> getClientes();
    
    //dado un cliente.id se busca en la table y se devuelve todo el objeto cliente
    public Cliente getCliente(Cliente cliente);
    
    // si el cliente.id tiene un valor se busca y se actualiza
    //si el cliente.id no tiene valor, se inserta el objeto en la tabla
    public void save (Cliente cliente);
    
    //Elimina el registro que tiene el id igual a cliente.id
    public void delete(Cliente cliente);
    
    
}
