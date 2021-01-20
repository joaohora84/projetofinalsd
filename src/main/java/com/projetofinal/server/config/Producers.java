/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.config;

import com.projetofinal.server.dao.DAO;
import com.projetofinal.server.dao.JpaDAO;
import com.projetofinal.server.model.Cadastro;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joao
 */
public class Producers {
    
    @Produces
    @PersistenceContext
    private EntityManager em;
    
    @Produces
    public <T extends Cadastro> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
    
}
