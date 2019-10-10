/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("UpdateLicenseByidResource")
public class UpdateLicenseByidResource {

     @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateLicenseByIdResource
     */
    public UpdateLicenseByidResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.UpdateLicenseByIdResource
     * @return an instance of ec.edu.espe.gruasService.model.Operator
     */
   

    
    /**
     * PUT method for updating or creating an instance of UpdateLicenseByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putText(Operator content) {
        return updateLicenseId(content);
    }
    
     public String updateLicenseId(Operator operator) {

        Conexion conec = new Conexion();
        try {

            Connection con = null;
            con = conec.getConection();
            PreparedStatement ps;
        
            ps = con.prepareStatement("UPDATE `operator` SET `oplicense`=? WHERE opid=?");
         
            ps.setString(1, operator.getOperatorLicence());
            ps.setString(2,operator.getOperatorId() );
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.desconectar();
        return "successful license update";
    }
}
