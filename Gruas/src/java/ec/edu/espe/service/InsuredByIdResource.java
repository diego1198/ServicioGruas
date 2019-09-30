package ec.edu.espe.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espe.model.Insured;
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
 * @author Alexis
 */
@Path("insuredById")
public class InsuredByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorByIdResource
     */
    public InsuredByIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.OperatorByIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Insured getJson(@PathParam("id")String id) {
        Insured insured = new Insured();
        insured = getInsuredId(id);
        return insured;
    }

    /**
     * PUT method for updating or creating an instance of OperatorByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Operator content) {
    }
    
     public Insured getInsuredId(String id){
        Insured insured = new Insured();
        
        return insured;
    }
}
