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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("ServicioPorId")
public class ServicioPorIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioPorIdResource
     */
    public ServicioPorIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ServicioPorIdResource
     * @return an instance of ec.edu.espe.model.Servicio
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Servicio getJson(@PathParam("id")String id) {
        Servicio service = new Servicio();
        service = getServicioId(id);
        return service;
    }

    /**
     * PUT method for updating or creating an instance of ServicioPorIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Servicio content) {
    }
    
    public Servicio getServicioId(String id){
        Servicio service = new Servicio();
        
        return service;
    }
}
