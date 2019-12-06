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

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Operator")
public class Operator {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Operator
     */
    public Operator() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.Operator
     * @return an instance of ec.edu.espe.craneService.model.Operator
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ec.edu.espe.craneService.model.Operator getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Operator
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(ec.edu.espe.craneService.model.Operator content) {
    }
}
