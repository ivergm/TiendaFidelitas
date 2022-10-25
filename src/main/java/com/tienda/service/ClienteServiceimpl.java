/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ivmor
 */
@Service
public class ClienteServiceimpl implements ClienteService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
    //se utiliza una anotacion Autowired para que el objeto clienteDao
    //si ya esta en momoria se usa ese, sino se crea uno (singleton)
    
    @Autowired
    private ClienteDao clienteDao;
    
    //retorna la lista de clientes
    @Override
    @Transactional(readOnly= true)
    public List<Cliente> getClientes(){
    return (List<Cliente>)clienteDao.findAll();
    }
    
    //dado un cliente.id se busca en la table y se devuelve todo el objeto cliente
    @Override
    @Transactional(readOnly= true)
    public Cliente getCliente(Cliente cliente){
    return clienteDao.findById(cliente.getIdCliente()).orElse(null);
            }
    // si el cliente.id tiene un valor se busca y se actualiza
    //si el cliente.id no tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save (Cliente cliente){
        clienteDao.save(cliente);
        
    }
    
    
    //Elimina el registro que tiene el id igual a cliente.id
    @Override
    @Transactional
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }
    
    
}
