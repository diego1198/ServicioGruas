/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import ec.edu.espe.model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author henry
 */
@Path("upgradeOperatorLicenseOperatorId")
public class UpgradeOperatorLicenseOperatorIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpgradeOperatorLicenseOperatorIdResource
     */
    public UpgradeOperatorLicenseOperatorIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.UpgradeOperatorLicenseOperatorIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
     @Path("{operatorId}/{licence}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("operatorId")String id,@PathParam("licence")String licence) {
        
        String response=getOperatorId(id,licence);
        return response;
    }

    /**
     * PUT method for updating or creating an instance of UpgradeOperatorLicenseOperatorIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(Operator content) {
    }
    
    
    public String getOperatorId(String id,String licence) {
       // Report report = new Report();
        Conexion conec = new Conexion();
        System.out.println("zsxdgfchvjbhnlkm");
        try {
            Connection con = null;
            con = conec.getConection();
            System.out.println("5555555555555555555555555");
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("UPDATE `operator` SET `oplicence`=? WHERE `opid`=?");
            ps.setString(1, id);
            ps.setString(2, licence);
            
             ps.executeUpdate();
          
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "actualización exitosa";
    }

  
}
