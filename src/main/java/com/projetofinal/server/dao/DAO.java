/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.dao;

import com.projetofinal.server.model.Cadastro;
import javax.persistence.TypedQuery;

/**
 *
 * @author joao
 */
public interface DAO<T extends Cadastro> {
    
    TypedQuery<T> createQuery(String jpql);
    T findById(long id);
    T findByField(String fieldName, Object value);
    boolean delete(T entity);
    boolean delete(long id);
    long save(T entity);
    
}
