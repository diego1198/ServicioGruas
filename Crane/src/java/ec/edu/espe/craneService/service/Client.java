/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Client")
public class Client {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Client
     */
    public Client() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.Client
     * @return an instance of ec.edu.espe.gruasService.model.Client
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ec.edu.espe.gruasService.model.Client getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Client
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ec.edu.espe.gruasService.model.Client content) {
    }
}
