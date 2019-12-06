/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.CraneManager;
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
@Path("CraneManager")
public class CraneManagerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CraneManagerResource
     */
    public CraneManagerResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.CraneManagerResource
     * @return an instance of ec.edu.espe.craneService.model.CraneManager
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CraneManager getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CraneManagerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CraneManager content) {
    }
}
