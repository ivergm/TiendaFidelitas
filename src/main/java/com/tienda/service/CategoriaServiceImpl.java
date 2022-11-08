/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ivmor
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
    //se utiliza una anotacion Autowired para que el objeto categoriaDao
    //si ya esta en momoria se usa ese, sino se crea uno (singleton)
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    //retorna la lista de categorias
    @Override
    @Transactional(readOnly= true)
    public List<Categoria> getCategorias(boolean activos){
    var lista=(List<Categoria>)categoriaDao.findAll();
    if (activos){
        lista.removeIf(e -> !e.isActivo());
    }
    return lista;
    }
    
    //dado un categoria.id se busca en la table y se devuelve todo el objeto categoria
    @Override
    @Transactional(readOnly= true)
    public Categoria getCategoria(Categoria categoria){
    return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
            }
    // si el categoria.id tiene un valor se busca y se actualiza
    //si el categoria.id no tiene valor, se inserta el objeto en la tabla
    @Override
    @Transactional
    public void save (Categoria categoria){
        categoriaDao.save(categoria);
        
    }
    
    
    //Elimina el registro que tiene el id igual a categoria.id
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
  
    
    
}
