/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@Path("NumberOperatorLicenseResource")
public class NumberOperatorLicenseResource {
@Context
    private UriInfo context;

    /**
     * Creates a new instance of NumberOperatorLicenceResource
     */
    public NumberOperatorLicenseResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.NumberOperatorLicenceResource
     * @return an instance of ec.edu.espe.gruasService.model.Operator
     */
    @GET
    @Path("{typeLicense}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("typeLicense") String license) throws SQLException {
        
        ArrayList<Operator> op= new ArrayList();
        op=showRegisterList(license);
        String  tamanio =String.valueOf(op.size());
        
        return tamanio;
    }
    
    
        public ArrayList showRegisterList(String license) throws SQLException {
        Conexion connect = new Conexion();
        PreparedStatement state;
        state = connect.getConection().prepareStatement("SELECT * from operator where oplicense=? ");
        state.setString(1, license);
        ResultSet rs = state.executeQuery();
        Operator serviceClient;

        ArrayList<Operator> operator = new ArrayList();

        while (rs.next()) {
            serviceClient = new Operator(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5));
            operator.add(serviceClient);
        }
        rs.close();
        state.close();
        return operator;

    }


    /**
     * PUT method for updating or creating an instance of NumberOperatorLicenceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(Operator content) {
    }
}
