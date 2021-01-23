/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetofinal.server.rest;

import com.projetofinal.server.dao.DAO;
import com.projetofinal.server.model.Reserva;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author joao
 */
@Path("/reserva")
@Transactional
public class ReservaResource {

    @Inject
    private DAO<Reserva> dao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Reserva reserva) {
        return dao.save(reserva);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Reserva reserva) {

        return dao.save(reserva) > 0;

    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

}
