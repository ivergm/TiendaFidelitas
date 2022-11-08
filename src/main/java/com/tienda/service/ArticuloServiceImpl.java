/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ivmor
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
    //se utiliza una anotacion Autowired para que el objeto articuloDao
    //si ya esta en momoria se usa ese, sino se crea uno (singleton)
    
    @Autowired
    private ArticuloDao articuloDao;
    
    //retorna la lista de articulos
    @Override
    @Transactional(readOnly= true)
    public List<Articulo> getArticulos(boolean activos){
    var lista=(List<Articulo>)articuloDao.findAll();
    if (activos){
        lista.removeIf(e -> !e.isActivo());
    }
    return lista;
    }
    
    //dado un articulo.id se busca en la table y se devuelve todo el objeto articulo
    @Override
    @Transactional(readOnly= true)
    public Articulo getArticulo(Articulo articulo){
    return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
            }
    // si el articulo.id tiene un valor se busca y se actualiza
    //si el articulo.id no tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save (Articulo articulo){
        articuloDao.save(articulo);
        
    }
    
    
    //Elimina el registro que tiene el id igual a articulo.id
    @Override
    @Transactional
    public void delete(Articulo articulo){
        articuloDao.delete(articulo);
    }

}