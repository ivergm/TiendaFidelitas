/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

/**
 *
 * @author ivmor
 */
public interface ArticuloService {
    // creacion de 4 metodos de un Crud (create, read, update and delete)
    
    //retorna la lista de articulos
    public List<Articulo> getArticulos(boolean activos);
    
    //dado un articulo.id se busca en la table y se devuelve todo el objeto articulo
    public Articulo getArticulo(Articulo articulo);
    
    // si el articulo.id tiene un valor se busca y se actualiza
    //si el articulo.id no tiene valor, se inserta el objeto en la tabla
    public void save (Articulo articulo);
    
    //Elimina el registro que tiene el id igual a articulo.id
    public void delete(Articulo articulo);
    
    
}
