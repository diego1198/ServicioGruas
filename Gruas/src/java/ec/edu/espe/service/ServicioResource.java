/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Servicio;
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
 * @author diego
 */
@Path("servicio")
public class ServicioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioResource
     */
    public ServicioResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ServicioResource
     * @return an instance of ec.edu.espe.model.Servicio
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Servicio getJson() {
        Servicio service = new Servicio("EXP00123", "1726010638", "1714030648", "PBH-9874");
        
        return service;
    }

    /**
     * PUT method for updating or creating an instance of ServicioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(Servicio content) {
    }
}
