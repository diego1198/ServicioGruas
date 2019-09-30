/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espe.model.Operator;
import ec.edu.espe.model.Servicio;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("operatorById")
public class OperatorByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorByIdResource
     */
    public OperatorByIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.OperatorByIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Operator getJson(@PathParam("id")String id) {
        Operator operator = new Operator();
        operator = getOperatorId(id);
        return operator;
    }

    /**
     * PUT method for updating or creating an instance of OperatorByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Operator content) {
    }
    
     public Operator getOperatorId(String id){
        Operator operator = new Operator();
        
        return operator;
    }
}
