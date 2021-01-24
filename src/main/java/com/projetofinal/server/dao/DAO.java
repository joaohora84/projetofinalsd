/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.dao;

import com.projetofinal.server.model.Cadastro;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.ws.rs.QueryParam;

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
    
    /*Veiculo*/
    
    List<T> findByVeiculoBusca1(
            String cidade,
            String modelo,
            double preco_inicial,
            double preco_final
    );
    
    List<T> findByVeiculoBusca2(
            String cidade,
            double preco_inicial,
            double preco_final,
            boolean ar_condicionado,
            String cambio
    );
    
    List<T> findByVeiculoBusca3(String cidade,
            double preco_inicial,
            double preco_final,
            boolean ar_condicionado,
            String cambio,
            String combustivel
    );
    
    

}
