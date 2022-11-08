/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author ivmor
 */
public interface CategoriaService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
    //retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
    
    //dado un categoria.id se busca en la table y se devuelve todo el objeto categoria
    public Categoria getCategoria(Categoria categoria);
    
    // si el categoria.id tiene un valor se busca y se actualiza
    //si el categoria.id no tiene valor, se inserta el objeto en la tabla
    public void save (Categoria categoria);
    
    //Elimina el registro que tiene el id igual a categoria.id
    public void delete(Categoria categoria);
    
    
}
