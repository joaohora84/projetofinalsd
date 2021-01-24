/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.rest;

import com.projetofinal.server.dao.DAO;
import com.projetofinal.server.model.Veiculo;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author joao
 */
@Path("/veiculo")
@Transactional
public class VeiculoResource {

    @Inject
    private DAO<Veiculo> dao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Veiculo veiculo) {
        return dao.save(veiculo);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Veiculo veiculo) {
        return dao.save(veiculo) > 0;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @GET
    @Path("modelo/{modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo findByModelo(@PathParam("modelo") String modelo) {

        Veiculo veiculo = dao.findByField("modelo", modelo);

        return veiculo;

    }

    @GET
    @Path("busca1")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findByVeiculoBusca1(@QueryParam("cidade") String cidade,
            @QueryParam("modelo") String modelo,
            @QueryParam("preco_inicial") double preco_inicial,
            @QueryParam("preco_final") double preco_final) {

        List<Veiculo> veiculos = null;

        veiculos = dao.findByVeiculoBusca1(cidade, modelo, preco_inicial, preco_final);

        return veiculos;

    }

    @GET
    @Path("busca2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findByVeiculoBusca2(@QueryParam("cidade") String cidade,
            @QueryParam("preco_inicial") double preco_inicial,
            @QueryParam("preco_final") double preco_final,
            @QueryParam("ar_condicionado") boolean ar_condicionado,
            @QueryParam("cambio") String cambio) {

        List<Veiculo> veiculos = null;

        veiculos = dao.findByVeiculoBusca2(cidade, preco_inicial, preco_final, ar_condicionado, cambio);

        return veiculos;

    }

    @GET
    @Path("busca3")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findByVeiculoBusca3(@QueryParam("cidade") String cidade,
            @QueryParam("preco_inicial") double preco_inicial,
            @QueryParam("preco_final") double preco_final,
            @QueryParam("ar_condicionado") boolean ar_condicionado,
            @QueryParam("cambio") String cambio,
            @QueryParam("combustivel") String combustivel) {

        List<Veiculo> veiculos = null;

        veiculos = dao.findByVeiculoBusca3(cidade, preco_inicial, preco_final, ar_condicionado, cambio, combustivel);

        return veiculos;

    }

}
