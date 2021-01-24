/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.dao;

import com.projetofinal.server.model.Cadastro;
import com.projetofinal.server.model.Veiculo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author joao
 */
public class JpaDAO<T extends Cadastro> implements DAO<T> {

    private final EntityManager em;
    private final Class<T> classe;

    public JpaDAO(EntityManager em, Class<T> classe) {
        this.em = em;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        return em.find(classe, id);
    }

    @Override
    public boolean delete(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public boolean delete(long id) {
        T entity = findById(id);
        return delete(entity);
    }

    @Override
    public long save(T entity) {
        if (entity.getId() > 0) {
            em.merge(entity);
        } else {
            em.persist(entity);
        }

        return entity.getId();
    }

    @Override
    public TypedQuery<T> createQuery(String jpql) {
        return em.createQuery(jpql, classe);
    }

    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o "
                + " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName, value);
        return query.getSingleResult();
    }

    /**
     * VEICULO      *
     */
    @Override
    public List<T> findByVeiculoBusca1(String cidade,
            String modelo,
            double preco_inicial,
            double preco_final) {

        String jpql = "select v from Veiculo v , Cidade c where"
                + " v.cidade.id = c.id and c.nome like :cidade"
                + " and v.modelo like :modelo"
                + " and v.preco between :preco_inicial and :preco_final";

        TypedQuery<T> query = em.createQuery(jpql, classe);

        query.setParameter("cidade", cidade);
        query.setParameter("modelo", modelo);
        query.setParameter("preco_inicial", preco_inicial);
        query.setParameter("preco_final", preco_final);

        return query.getResultList();
    }

    @Override
    public List<T> findByVeiculoBusca2(String cidade,
            double preco_inicial, double preco_final,
            boolean ar_condicionado, String cambio) {

        String jpql = "select v from Veiculo v , Cidade c where"
                + " v.cidade.id = c.id and c.nome like :cidade"
                + " and v.preco between :preco_inicial and :preco_final"
                + " and v.ar_condicionado = :ar_condicionado"
                + " and v.cambio like :cambio";

        TypedQuery<T> query = em.createQuery(jpql, classe);

        query.setParameter("cidade", cidade);
        query.setParameter("preco_inicial", preco_inicial);
        query.setParameter("preco_final", preco_final);
        query.setParameter("ar_condicionado", ar_condicionado);
        query.setParameter("cambio", cambio);

        return query.getResultList();

    }

    @Override
    public List<T> findByVeiculoBusca3(String cidade, double preco_inicial,
            double preco_final, boolean ar_condicionado,
            String cambio, String combustivel) {

        String jpql = "select v from Veiculo v , Cidade c where"
                + " v.cidade.id = c.id and c.nome like :cidade"
                + " and v.preco between :preco_inicial and :preco_final"
                + " and v.ar_condicionado = :ar_condicionado"
                + " and v.cambio like :cambio"
                + " and v.combustivel like :combustivel";

        TypedQuery<T> query = em.createQuery(jpql, classe);

        query.setParameter("cidade", cidade);
        query.setParameter("preco_inicial", preco_inicial);
        query.setParameter("preco_final", preco_final);
        query.setParameter("ar_condicionado", ar_condicionado);
        query.setParameter("cambio", cambio);
        query.setParameter("combustivel", combustivel);

        return query.getResultList();

    }

}
