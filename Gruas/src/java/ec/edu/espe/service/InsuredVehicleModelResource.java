/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;


import ec.edu.espe.model.insuredVehicle;
import java.util.ArrayList;
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
 * @author Luis
 */
@Path("insuredVehicleModel")
public class InsuredVehicleModelResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InsuredVehicleModelResource
     */
    public InsuredVehicleModelResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.InsuredVehicleModelResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     @Path("{model}")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
     public ArrayList<insuredVehicle> getJson(@PathParam("model")String model) {
        ArrayList<insuredVehicle> listVehicles = new ArrayList<>();
        listVehicles = getInsuredVehicleModel(model);
        return listVehicles;
    }

    
    
    
    /**
     * PUT method for updating or creating an instance of InsuredVehicleModelResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private ArrayList<insuredVehicle> getInsuredVehicleModel(String model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
